package org.example.dataanalyticsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication
@EnableKafkaStreams
public class DataAnalyticsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataAnalyticsServiceApplication.class, args);
    }

}
