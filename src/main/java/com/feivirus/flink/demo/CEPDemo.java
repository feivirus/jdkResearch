package com.feivirus.flink.demo;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.cep.pattern.conditions.SimpleCondition;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.List;
import java.util.Map;

/**
 * @author feivirus
 */
public class CEPDemo {

    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Event a = new Event(40, "start", 1.0);
        Event b = new Event(42, "c", 1.0);
        Event c = new Event(43, "b", 32.0);
        Event d = new Event(44, "d", 11d);
        Event e = new Event(45, "e", 5d);
        Event f = new Event(46, "f", 100d);
        Event g = new Event(47, "end", 12d);

        DataStream input = env.fromElements(a, b, c, d, e, f, g);

        Pattern<Event, ?> pattern = Pattern.<Event>begin("start").where(new SimpleCondition<Event>() {

            @Override
            public boolean filter(Event event) throws Exception {
                return event.getId().intValue() == 42;
            }
        }).next("middle").subtype(Event.class).where(
                new SimpleCondition<Event>() {
                    @Override
                    public boolean filter(Event event) throws Exception {
                        return event.getVolume() >= 10;
                    }
                }
        ).followedBy("end").where(
                new SimpleCondition<Event>() {
                    @Override
                    public boolean filter(Event event) throws Exception {
                        return event.getName().equals("end");
                    }
                }
        );

        PatternStream<Event> patternStream = CEP.pattern(input, pattern);

        DataStream result = patternStream.select(
                new PatternSelectFunction<Event, Alert>() {
                    @Override
                    public Alert select(Map<String, List<Event>> map) throws Exception {
                        Alert alert = new Alert(1, "CEPDemoAlert", 0);

                        for (Map.Entry<String, List<Event>> entry : map.entrySet()) {
                            System.out.println("key: " + entry.getKey());
                            for (Event event : entry.getValue()) {
                                System.out.println("value: " + event.getName());
                                alert.setCount(alert.getCount().intValue() + 1);
                            }

                        }
                        return alert;
                    }
                }
        );
        result.print();

        try {
            env.execute("CEPDemo");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
