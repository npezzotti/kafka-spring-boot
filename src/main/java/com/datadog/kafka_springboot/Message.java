package com.datadog.kafka_springboot;

import java.util.UUID;

public class Message {
    String message;
    UUID userId;

    public Message() {

    }

    public Message(String message, UUID userId) {
        this.message = message;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", userId=" + userId +
                '}';
    }
}
