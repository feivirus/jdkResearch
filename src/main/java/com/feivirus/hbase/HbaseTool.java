package com.feivirus.hbase;

import java.io.IOException;
import java.util.*;

import com.feivirus.hbase.coprocessor.autogenerated.Sum;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MetaTableAccessor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.coprocessor.Batch;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.ipc.CoprocessorRpcUtils.BlockingRpcCallback;
import org.apache.hadoop.hbase.ipc.CoprocessorRpcUtils;
import org.apache.hadoop.hbase.mapreduce.HashTable;
import org.apache.hadoop.hbase.regionserver.HRegionFileSystem;
import org.apache.hadoop.hbase.util.Bytes;
import com.google.protobuf.RpcCallback;
import org.apache.hadoop.hbase.util.EnvironmentEdgeManager;
import org.springframework.context.annotation.Bean;

/**
 * @author feivirus
 */
public class HbaseTool {
    private static String BASE_PATH = "hbase/data/";
    private static String REGION_INFO_FILE = ".regioninfo";
    private static List<String> regionServers = new ArrayList<>();
    private static byte[] FAMILY = Bytes.toBytes("info");
    private static byte[] SN = Bytes.toBytes("sn");
    private static byte[] SERVER = Bytes.toBytes("server");
    private static byte[] STATE = Bytes.toBytes("state");

    public static void main(String[] args) throws Exception{
        org.apache.hadoop.conf.Configuration conf = getHBaseConfiguration(0);
        String tableName = "DATA_CENTER:WKD_RISK_SNAPSHOT";

        List<String> metaRegions = getMetaRegions(conf, tableName);
        Map<String, RegionInfo> hdfsRegions = getHdfsRegions(conf, tableName.replace(":", "/"));
        Set<String> hdfsRegionNames = hdfsRegions.keySet();
        //hdfsRegionNames.removeAll(new HashSet<>(metaRegions));

        Connection conn = ConnectionFactory.createConnection(conf);
        Table table = conn.getTable(TableName.valueOf("hbase:meta"));

        regionServers.add("qav2,16020");
        int rsLength = regionServers.size();
        int i = 0;

        for (String regionName : hdfsRegionNames) {

            String sn = regionServers.get(i % rsLength);
            String[] snSig = sn.split(",");

            RegionInfo hri = hdfsRegions.get(regionName);
            Put info = MetaTableAccessor.makePutFromRegionInfo(hri, EnvironmentEdgeManager.currentTime());
            info.addColumn(FAMILY, SN, Bytes.toBytes(sn));
            info.addColumn(FAMILY, SERVER, Bytes.toBytes(snSig[0] + ":" + snSig[1]));
            info.addColumn(FAMILY, STATE, Bytes.toBytes("CLOSE"));

            table.put(info);
            i++;
        }

        conn.close();
    }

    public static List<String> getMetaRegions(Configuration conf, String tableName) throws Exception {

        Connection conn = ConnectionFactory.createConnection(conf);
        Table table = conn.getTable(TableName.valueOf("hbase:meta"));

        PrefixFilter filter = new PrefixFilter(Bytes.toBytes(tableName + ","));

        Scan scan = new Scan();
        scan.setFilter(filter);

        List<String> metaRegions = new ArrayList<>();

        Iterator<Result> iterator = table.getScanner(scan).iterator();
        while (iterator.hasNext()) {
            Result result = iterator.next();
            metaRegions.add(Bytes.toString(result.getRow()));
        }

        conn.close();
        return metaRegions;
    }

    public static Map<String, RegionInfo> getHdfsRegions(Configuration conf, String tablePath) throws Exception {

        FileSystem fs = FileSystem.get(conf);
        fs.setWorkingDirectory(new Path("/"));
        Path path = new Path(BASE_PATH + tablePath);

        Map<String, RegionInfo> hdfsRegions = new HashMap<>();

        FileStatus[] list = fs.listStatus(path);
        for (FileStatus status : list) {
            if (!status.isDirectory()) {
                continue;
            }

            boolean isRegion = false;
            FileStatus[] regions = fs.listStatus(status.getPath());
            for (FileStatus regionStatus : regions) {
                if (regionStatus.toString().contains(REGION_INFO_FILE)) {
                    isRegion = true;
                    break;
                }
            }

            if (!isRegion) {
                continue;
            }

            RegionInfo hri = HRegionFileSystem.loadRegionInfoFileContent(fs, status.getPath());
            hdfsRegions.put(hri.getRegionNameAsString(), hri);

        }

        return hdfsRegions;

    }

    /**
     * @param environment 0 QA 1 MyHost
     * @return
     */
    public static org.apache.hadoop.conf.Configuration getHBaseConfiguration(int environment) {
        if (environment == 0) {
            return getQAHBaseConfiguration();
        }
        return null;
    }


    public static org.apache.hadoop.conf.Configuration getQAHBaseConfiguration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();

        configuration.set("hbase.rootdir", "hdfs://qav2:9000/hbase");
        configuration.set("hbase.cluster.distributed", "true");
        configuration.set("hbase.zookeeper.quorum", "192.168.1.192");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        configuration.set("zookeeper.znode.parent", "/hbase");
        configuration.set("hbase.zookeeper.property.dataDir", " /media/hbase/data");
        configuration.set("base.unsafe.stream.capability.enforce", "false");
        configuration.set("hbase.defaults.for.version.skip", "true");
        configuration.set("hbase.rpc.timeout", "1800000");
        configuration.set("hbase.client.operation.timeout", "1800000");
        configuration.set("hbase.client.scanner.caching", "1000");
        configuration.set("hbase.client.scanner.timeout.period", "1800000");

        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        configuration.set("fs.defaultFS", "hdfs://192.168.1.189:9000");
        return configuration;
    }
}
