package com.feivirus.kafka.transaction.onlywrite;

import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * @author feivirus
 */
public class TransactionProducer {
    public static Properties getProps() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("client.id", "producer-syn-2");
        properties.put("transactional.id", "producer-1");
        properties.put("enable.idempotence", true);
        return properties;
    }

    public static void main(String[] args) {
        //KafkaProducer<String, String> producer =
    }
}
