package com.feivirus.hadoop.spend;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 * 报销统计
 * @author feivirus
 *
 */
public class SpendCount {
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        config.set("fs.defaultFS", "hdfs://localhost:8020");
        
        String[] otherArgStrings;
        otherArgStrings = new GenericOptionsParser(config, args).getRemainingArgs();
        if (otherArgStrings.length < 2) {
            System.out.println("Usage: spendcount <int> <out>");
            return;
        }           
       
        Job job = Job.getInstance();
        job.setJarByClass(SpendCount.class);
        job.setMapperClass(SpendMapper.class);
        job.setReducerClass(SpendReducer.class);
        job.setPartitionerClass(SpendPartitioner.class);
        job.setNumReduceTasks(5);
        
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(SpendBean.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(SpendBean.class);        
        
        for (int i = 0; i < otherArgStrings.length - 1; i++) {
            FileInputFormat.addInputPath(job, new Path(otherArgStrings[i]));
        }
        FileOutputFormat.setOutputPath(job, new Path(otherArgStrings[otherArgStrings.length  - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
