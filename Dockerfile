FROM openjdk:16-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
WORKDIR /workspace/app/target/dependency
RUN jar -xf ../*.jar

FROM openjdk:16-jdk-alpine

ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
RUN wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer
ENTRYPOINT ["java","-javaagent:dd-java-agent.jar","-cp","app:app/lib/*","com.datadog.kafka_springboot.KafkaSpringbootApplication"]
