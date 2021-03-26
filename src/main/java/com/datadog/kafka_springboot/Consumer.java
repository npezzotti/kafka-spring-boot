package com.datadog.kafka_springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    public static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.GROUP_ID)
    public void getMessage(Message message) {
        logger.info(String.format("Message received: %s", message));
    }
}