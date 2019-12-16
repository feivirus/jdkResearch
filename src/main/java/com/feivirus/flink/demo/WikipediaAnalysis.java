package com.feivirus.flink.demo;

import org.apache.flink.api.common.functions.FoldFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditEvent;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditsSource;


/**
 * @author feivirus
 */
public class WikipediaAnalysis {
    public static void main(String[] args) throws  Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<WikipediaEditEvent> editsStream = env.addSource(new WikipediaEditsSource());
        //key 是string， 用户名，类似map任务的
        KeyedStream<WikipediaEditEvent, String> editsKeyedStream = editsStream.keyBy(new KeySelector<WikipediaEditEvent, String>() {
            @Override
            public String getKey(WikipediaEditEvent wikipediaEditEvent) throws Exception {
                return wikipediaEditEvent.getUser();
            }
        });

        DataStream<Tuple2<String, Long>> result = editsKeyedStream.timeWindow(Time.seconds(5))
                .fold(new Tuple2<>("", 0L), new FoldFunction<WikipediaEditEvent, Tuple2<String, Long>>() {
                    @Override
                    public Tuple2<String, Long> fold(Tuple2<String, Long> tuple2, WikipediaEditEvent o) throws Exception {
                        tuple2.f0 = o.getUser();
                        tuple2.f1 += o.getByteDiff();
                        return null;
                    }
                });
        result.print();
        env.execute();
    }
}
