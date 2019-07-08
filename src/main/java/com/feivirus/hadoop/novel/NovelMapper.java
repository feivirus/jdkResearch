package com.feivirus.hadoop.novel;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class NovelMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private Text text = new Text();
    private LongWritable longWritable = new LongWritable();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, LongWritable>.Context context)
            throws IOException, InterruptedException {
        String line = value.toString().trim();
        
        if (StringUtils.isEmpty(line)) {
            return;
        }
        
        Result result = ToAnalysis.parse(line);
        List<Term> terms = result.getTerms();
        Iterator<Term> iterator = terms.iterator();
        
        while (iterator.hasNext()) {
           Term term = iterator.next();
           
           longWritable.set(1);
           text.set(term.getName());
           context.write(text, longWritable);
        }
        
    }   

}
