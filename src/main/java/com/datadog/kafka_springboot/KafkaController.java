package com.datadog.kafka_springboot;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final Producer producer;

    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam String message, @RequestParam Integer userId) {
        this.producer.writeMessage(new Message(message, userId));
    }
}
