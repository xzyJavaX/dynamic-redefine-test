package com.xzy.test.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class KafkaDemoController {
    private final KafkaProducer<String, String> kafkaProducer;

    public KafkaDemoController() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<String, String>(properties);
    }

    @GetMapping("/kafka")
    public void sendMessage() {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("topic", "message");
        kafkaProducer.send(record);
    }
}
