package com.javatechie.spring.cloud.stream.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(CustomSource.class)
public class SpringCloudStreamConsumerApplication {

    private Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

    @StreamListener("input1")
    public void consumeMessageFromInput1(Book book) {
        logger.info("Consume payload : " + book);
    }

    @StreamListener("input2")
    public void consumeMessageFromInput2(Book book) {
        logger.info("Consume payload : " + book);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
    }

}
