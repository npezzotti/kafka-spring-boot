# Kafka-Springboot
This sandbox demonstrates autoinstrumentation for Kafka using the Kafka-Spring framework.
### Setup
1. Run `docker-compose up`
2. Generate some messages with the following curl command:
    ```
    kafka-springboot % curl -X POST localhost:8080/kafka/publish \
    --data-urlencode "message=This is a message from $(hostname)" \
    --data-urlencode "userId=$(uuidgen)" \
    ```
3. Check the console to see the message was sent to the Broker and then consumed:
    ```
    spring-boot    | 2021-03-28 17:43:49.053  INFO 1 --- [nio-8080-exec-8] com.datadog.kafka_springboot.Producer    : Message sent: Message{message='This is a message from COMP-C02D31D1ML87', userId=67197880-1cb1-4e0f-9955-bdeee3973df0}
    
    spring-boot    | 2021-03-28 17:43:49.060  INFO 1 --- [ntainer#0-0-C-1]
    com.datadog.kafka_springboot.Consumer    : Message received: Message{message='This is a message from COMP-C02D31D1ML87', userId=67197880-1cb1-4e0f-9955-bdeee3973df0}
    ```
4. Check the APM page for `kafka.produce` and `kafka.consume` spans
## References:
- Kafka-Spring: https://spring.io/projects/spring-kafka

