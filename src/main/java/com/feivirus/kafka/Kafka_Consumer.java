package com.feivirus.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Kafka_Consumer {
    public static void main(String[] args) {
        String topicName = "test";
        Properties properties= new Properties();
        
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "test");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", 1000);
        properties.put("session.timeout.ms", "30000");        
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(topicName));
        
        System.out.println("subscribe to topic " + topicName);
        
        int i = 0;
        
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            
            for(ConsumerRecord<String, String> record : records) {
                System.out.printf("offset = %d, key = %d, value = %s", record.offset(), record.key(), record.value());
            }
        }
    }
}
