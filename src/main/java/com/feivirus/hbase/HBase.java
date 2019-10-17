package com.feivirus.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.mapreduce.HashTable;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.context.annotation.Bean;

public class HBase {    
    private int environment;
    
    public static void main(String[] args) {
        HBase hBase = new HBase();       
        hBase.setEnvironment(1);
        Table table = null;
        
        if (hBase.getEnvironment() == 0) {
            table = hBase.initHBaseTable("DATA_CENTER:WAKANDA_GPS");
        }
        if (hBase.getEnvironment() == 1) {
            table = hBase.initHBaseTable("emp");
        }        
        
        hBase.testScan(table);
        
    }
    
    public void testGet(Table table) {
        
    }
    
    public void testScan(Table table) {
        Scan scan = new Scan();
        
        if (environment == 0) {
            scan.addColumn(Bytes.toBytes("0"), Bytes.toBytes("JNY_ID"));
            scan.addColumn(Bytes.toBytes("0"), Bytes.toBytes("PLATE_NO"));
        }
        if (environment == 1) {
            scan.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("name"));
            scan.addColumn(Bytes.toBytes("personal data"), Bytes.toBytes("city"));
        }

        
        try {
            ResultScanner resultScanner = table.getScanner(scan);
            
//            for(Result result = resultScanner.next(); result != null; result = resultScanner.next()) {
//                System.out.println("扫描一行 ");
//                System.out.println(result.getColumnCells(Bytes.toBytes("0"), Bytes.toBytes("JNY_ID")));
//            }
            for (Result result : resultScanner) {
                System.out.println("扫描一行 ");
                if (environment == 0) {
                    System.out.println(result.getColumnCells(Bytes.toBytes("0"), Bytes.toBytes("JNY_ID")));
                }
                if (environment == 1) {
                    System.out.println(result.getColumnCells(Bytes.toBytes("personal data"), Bytes.toBytes("name")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    
    public void testPut(Table table) {
        
    }
    
    public Admin getAdmin(Connection connection) {
        if (connection == null) {
            return null;
        }
        
        Admin admin = null;
        try {
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }
    
   
    public Connection getConnection(org.apache.hadoop.conf.Configuration configuration) {
        Connection connection = null;
        
        try {
            connection = ConnectionFactory.createConnection(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }        
        return connection;
    }
    
    /**
     * @param environment
     * 0 QA 1 MyHost
     * @return
     */
    public org.apache.hadoop.conf.Configuration getHBaseConfiguration(int environment) {
        if (environment == 0) {
            return getQAHBaseConfiguration();
        }
        if (environment == 1) {
            return getMyHBaseConfiguration();
        }
        return null;
    }
    
    public org.apache.hadoop.conf.Configuration getMyHBaseConfiguration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        
        configuration.set("hbase.rootdir", "hdfs://localhost:8020/hbase");
        configuration.set("hbase.cluster.distributed", "true");
        configuration.set("hbase.zookeeper.quorum", "localhost");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        configuration.set("zookeeper.znode.parent", "/hbase");
        //configuration.set("hbase.zookeeper.property.dataDir", " /media/hbase/data");
        configuration.set("base.unsafe.stream.capability.enforce", "false");
        configuration.set("hbase.defaults.for.version.skip", "true");
        
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        return configuration;
    }
    
    public org.apache.hadoop.conf.Configuration getQAHBaseConfiguration() {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        
        configuration.set("hbase.rootdir", "hdfs://qav2:9000/hbase");
        configuration.set("hbase.cluster.distributed", "true");
        configuration.set("hbase.zookeeper.quorum", "192.168.1.192");
        configuration.set("hbase.zookeeper.property.clientPort", "2181");
        configuration.set("zookeeper.znode.parent", "/hbase");
        configuration.set("hbase.zookeeper.property.dataDir", " /media/hbase/data");
        configuration.set("base.unsafe.stream.capability.enforce", "false");
        configuration.set("hbase.defaults.for.version.skip", "true");
        
        configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        configuration.set("fs.defaultFS", "hdfs://192.168.1.189:9000");
        return configuration;
    }
    
    public Table initHBaseTable(String tableName) {        
        Configuration configuration = getHBaseConfiguration(1);
        Connection connection = getConnection(configuration);
        
        try {
            Table table = connection.getTable(TableName.valueOf(tableName));
            return table;            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getEnvironment() {
        return environment;
    }

    public void setEnvironment(int environment) {
        this.environment = environment;
    }    
}
