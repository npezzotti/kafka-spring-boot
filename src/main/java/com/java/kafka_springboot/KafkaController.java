package com.java.kafka_springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final Producer producer;

    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public ResponseEntity<String> sendMessageToKafkaTopic(@RequestParam String message, @RequestParam UUID userId) {
        this.producer.writeMessage(new Message(message, userId));
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}
