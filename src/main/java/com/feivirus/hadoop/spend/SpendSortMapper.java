package com.feivirus.hadoop.spend;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SpendSortMapper extends Mapper<LongWritable, Text, SpendBean, Text> {
    private  SpendBean bean = new SpendBean();
    private Text text = new Text();
    
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, SpendBean, Text>.Context context)
            throws IOException, InterruptedException {
        StringTokenizer tokenizer = new StringTokenizer(value.toString());
        String userName = tokenizer.nextToken();
        String addr = tokenizer.nextToken();
        String bizType = tokenizer.nextToken();
        String strMoney = tokenizer.nextToken();
        int money = Integer.parseInt(strMoney);        
       
        bean.setAddress(new Text(addr));
        bean.setUserName(new Text(userName));
        bean.setBizType(new Text(bizType));
        bean.setMoney(new IntWritable(money));
        
        text.set(userName);
        
        context.write(bean, text);
    }
    
}
