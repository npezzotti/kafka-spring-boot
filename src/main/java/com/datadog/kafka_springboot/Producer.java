package com.datadog.kafka_springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void writeMessage(Message message) {
        this.kafkaTemplate.send(Constants.TOPIC_NAME, message);
        logger.info(String.format("Message sent: %s", message));
    }

}
