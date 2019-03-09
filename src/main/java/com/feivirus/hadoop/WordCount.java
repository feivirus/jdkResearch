package com.feivirus.hadoop;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;

public class WordCount {
	
	public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
		private final static IntWritable one = new IntWritable(1);
		
		private Text word = new Text();

		/***
		 * value的默认输入是文本的一行数据, key是偏移量
		 */
		@Override
		public void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			//value是一行数据
			StringTokenizer sto = new StringTokenizer(value.toString());
			
			while(sto.hasMoreTokens()) {
				word.set(sto.nextToken());
				context.write(word, one);
			}
		}		
	}
	
	public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		private IntWritable result = new IntWritable();

		/***
		 * values 同一个key对应的所有值
		 */
		@Override
		protected void reduce(Text key, Iterable<IntWritable> values,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
				//values是相同key的元素对应的值得集合
				int sum = 0;
				for(IntWritable val : values) {
					sum += val.get();
				}
				result.set(sum);
				context.write(key, result);
		}
	}
		
	public static void main(String[] args) throws Exception{
		Configuration configuration = new Configuration();
		String[] otherArgStrings = new GenericOptionsParser(configuration, args).getRemainingArgs();
		
		if (otherArgStrings.length < 2) {
			System.out.println("Usage: wordcount <int> <out>");
			return;
		}
		
		Job  job = Job.getInstance(configuration, "word count");
		
		job.setJarByClass(WordCount.class);
		job.setMapperClass(TokenizerMapper.class);
		job.setCombinerClass(IntSumReducer.class);
		job.setReducerClass(IntSumReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		for (int i = 0; i < otherArgStrings.length - 1; i++) {
			FileInputFormat.addInputPath(job, new Path(otherArgStrings[i]));
		}
		FileOutputFormat.setOutputPath(job, new Path(otherArgStrings[otherArgStrings.length  - 1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
