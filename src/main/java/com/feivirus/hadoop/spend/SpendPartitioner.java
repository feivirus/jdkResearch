package com.feivirus.hadoop.spend;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class SpendPartitioner extends Partitioner<Text, SpendBean>{
    
    private static Map<String, Integer> provinces = new HashMap<String, Integer>();
    
    static {
        provinces.put("北京", 0);
        provinces.put("江西", 1);
        provinces.put("广东", 2);
        provinces.put("湖南", 3);
        provinces.put("上海", 4);
    }

    @Override
    public int getPartition(Text key, SpendBean bean, int numPartitions) {
       Integer province = provinces.get(bean.getAddress().toString());
       
       province = province == null ? 5 : province;
        return 0;
    }
}
