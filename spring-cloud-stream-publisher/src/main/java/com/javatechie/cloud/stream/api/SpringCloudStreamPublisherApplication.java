package com.javatechie.cloud.stream.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding(CustomSource.class)
@RestController
public class SpringCloudStreamPublisherApplication {
    @Autowired
    @Qualifier("output1")
    private MessageChannel output1;

    @Autowired
    @Qualifier("output2")
    private MessageChannel output2;

    @PostMapping("/publish-via-output1")
    public Book publishEventViaOutput1(@RequestBody Book book) {
        output1.send(MessageBuilder.withPayload(book).build());
        return book;
    }

    @PostMapping("/publish-via-output2")
    public Book publishEventViaOutput2(@RequestBody Book book) {
        output2.send(MessageBuilder.withPayload(book).build());
        return book;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
    }

}
