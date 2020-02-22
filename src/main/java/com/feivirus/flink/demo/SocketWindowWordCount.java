package com.feivirus.flink.demo;

import org.apache.commons.collections.CollectionUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;
import org.nlpcn.commons.lang.util.CollectionUtil;

/**
 * @author feivirus
 * bin/flink run -c com.feivirus.flink.demo.SocketWindowWordCount examples/feivirus/jdk-research-0.0.1-SNAPSHOT.jar --port 9000
 */
public class SocketWindowWordCount {
    public static void main(String[] args) throws  Exception{
        final int port;
        try {
            final ParameterTool params = ParameterTool.fromArgs(args);

            port = params.getInt("port");
        } catch (Exception ex) {
            System.err.println("usage: no port. run SocketWindowWordCount --port <port>");
            return;
        }

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> text = env.socketTextStream("localhost", port, "\n");
        System.out.println("---feivirus---任务开始");

        DataStream<WordWithCount> windowCount = text
                .flatMap(new FlatMapFunction<String, WordWithCount>() {
                    @Override
                    public void flatMap(String s, Collector<WordWithCount> collector) throws Exception {
                        for(String word : s.split("\\s")) {
                            collector.collect(new WordWithCount(word, 1L));
                            System.out.println("---feivirus---flatmap--任务: " + word);
                        }
                    }
                 })
                .keyBy("word")
                .timeWindow(Time.seconds(5), Time.seconds(1))
                .reduce(new ReduceFunction<WordWithCount>() {
                    @Override
                    public WordWithCount reduce(WordWithCount wordWithCount, WordWithCount t1) throws Exception {
                        System.out.println("---feivirus---reduce--任务" + wordWithCount.word +
                                "---" + t1.word);
                        return new WordWithCount(wordWithCount.word, wordWithCount.count + t1.count);
                    }
                });

        windowCount.print().setParallelism(1);
        env.execute("Socket Window WordCount");
    }

    public static class WordWithCount {
        public String word;
        public long count;

        public WordWithCount() {

        }

        public WordWithCount(String word, long count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public String toString() {
            return word + " : " + count;
        }
    }
}
