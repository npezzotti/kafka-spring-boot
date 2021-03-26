package com.datadog.kafka_springboot;

public class Message {
    String message;
    Integer userId;

    public Message() {

    }

    public Message(String message, Integer userId) {
        this.message = message;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
