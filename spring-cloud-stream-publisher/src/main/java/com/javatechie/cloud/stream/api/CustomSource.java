package com.javatechie.cloud.stream.api;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CustomSource {
    String output1="output1";
    String output2="output2";
    @Output(output1)
    MessageChannel output1();

    @Output(output2)
    MessageChannel output2();
}