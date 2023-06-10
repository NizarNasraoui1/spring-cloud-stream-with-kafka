package com.javatechie.spring.cloud.stream.api;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {

    String input1="input1";
    String input2="input2";
    @Input(input1)
    MessageChannel input1();

    @Input(input2)
    MessageChannel input2();
}