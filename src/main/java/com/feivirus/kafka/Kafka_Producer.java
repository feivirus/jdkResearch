package com.feivirus.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * 
 * @author feivirus
 *
 */
public class Kafka_Producer {
    public static void main(String[] args) {
        String topicName = "test";
        Properties properties= new Properties();
        
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        Producer<String, String> producer = new KafkaProducer<String, String>(properties);
        
        for(int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<String, String>(topicName, Integer.toString(i), Integer.toString(i)));            
          
        }
        System.out.println("msg send successfully");
        producer.close();
    }
}
