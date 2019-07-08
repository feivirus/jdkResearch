package com.feivirus.hadoop.novel;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class NovelCombiner extends Reducer<Text, LongWritable, LongWritable, Text>{

    @Override
    protected void reduce(Text key, Iterable<LongWritable> value,
            Reducer<Text, LongWritable, LongWritable, Text>.Context context) throws IOException, InterruptedException {
        Iterator<LongWritable> iterator = value.iterator();
        int count = 0;
        
        while(iterator.hasNext()) {
            LongWritable longWritable = iterator.next();
            count += longWritable.get();            
        }
        context.write(new LongWritable(count), key);
    }  

}
