package com.feivirus.hadoop.spend;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class SpendReducer extends Reducer<Text, SpendBean, Text, SpendBean>{

    @Override
    protected void reduce(Text key, Iterable<SpendBean> values, Reducer<Text, SpendBean, Text, SpendBean>.Context context)
            throws IOException, InterruptedException {
        int money = 0;
        
        for (SpendBean bean : values) {
            money += bean.getMoney().get();
        }
        context.write(key, new SpendBean(key, new IntWritable(money)));
    }    

}
