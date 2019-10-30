package com.feivirus.hbase.coprocessor;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.coprocessor.RegionObserver;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RowFilter;
import org.apache.hadoop.hbase.regionserver.InternalScanner;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class RegionObserverTest implements RegionObserver {
    private static final byte[] ADMIN = Bytes.toBytes("admin");
    private static final byte[] COLUMN_FAMILY = Bytes.toBytes("personalDet");
    private static final byte[] COLUMN = Bytes.toBytes("name");
    private static final byte[] VALUE = Bytes.toBytes("You can't see Admin details");

    public void preGetOp(ObserverContext<RegionCoprocessorEnvironment> c, Get get, List<Cell> result)
            throws IOException {
         if (Bytes.equals(get.getRow(), ADMIN)) {
            Cell cell = CellUtil.createCell(get.getRow(), COLUMN_FAMILY, COLUMN, System.currentTimeMillis(), (byte)4, VALUE);
            result.add(cell);
            c.bypass();
        }        
    }

    public void preScannerOpen(ObserverContext<RegionCoprocessorEnvironment> c, Scan scan) throws IOException {
        Filter filter = new RowFilter(CompareOp.NOT_EQUAL, new BinaryComparator(ADMIN));
        scan.setFilter(filter);
    }

    public boolean postScannerNext(ObserverContext<RegionCoprocessorEnvironment> c, InternalScanner s,
            List<Result> result, int limit, boolean hasNext) throws IOException {
            Result element = null;
            Iterator<Result> iterator = result.iterator();
            while (iterator.hasNext()) {
               element = iterator.next();
               if (Bytes.equals(element.getRow(), ADMIN)) {
                   iterator.remove();
                   break;
               }
                
            }
            return hasNext;
    }
        
    
    
}
