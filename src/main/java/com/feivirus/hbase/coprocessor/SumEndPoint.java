package com.feivirus.hbase.coprocessor;

import com.feivirus.hbase.coprocessor.autogenerated.Sum;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.google.protobuf.Service;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.Coprocessor;
import org.apache.hadoop.hbase.CoprocessorEnvironment;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.coprocessor.CoprocessorException;
import org.apache.hadoop.hbase.coprocessor.CoprocessorService;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.InternalScanner;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SumEndPoint /* extends Sum.SumService implements Coprocessor, CoprocessorService */{
//    private RegionCoprocessorEnvironment env;
//
//    @Override
//    public void start(CoprocessorEnvironment env) throws IOException {
//        if (env instanceof RegionCoprocessorEnvironment) {
//            this.env = (RegionCoprocessorEnvironment)env;
//        } else {
//            throw new CoprocessorException("Must be loaded on a table region");
//        }
//    }
//
//    public void stop(CoprocessorEnvironment env) throws IOException {
//
//    }
//
//    @Override
//    public Service getService() {
//        return this;
//    }
//
//    @Override
//    public void getSum(RpcController controller, Sum.SumRequest request, RpcCallback<Sum.SumResponse> done) {
//        Scan scan = new Scan();
//        scan.addFamily(Bytes.toBytes(request.getFamily()));
//        scan.addColumn(Bytes.toBytes(request.getFamily()), Bytes.toBytes(request.getColumn()));
//
//        Sum.SumResponse response = null;
//        InternalScanner scanner = null;
//
//        try {
//            scanner = env.getRegion().getScanner(scan);
//            List<Cell> results = new ArrayList();
//            boolean hasMore = false;
//            long sum = 0L;
//
//            do {
//                hasMore = scanner.next(results);
//                for (Cell cell : results) {
//                    sum += Bytes.toLong(CellUtil.cloneValue(cell));
//                }
//                results.clear();
//            } while (hasMore);
//
//            response = Sum.SumResponse.newBuilder().setSum(sum).build();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            if (scanner != null) {
//                try {
//                    scanner.close();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        done.run(response);
//    }
}
