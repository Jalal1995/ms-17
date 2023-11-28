package com.example.ms17task;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class Ms17TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ms17TaskApplication.class, args);
    }



    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {


    }



}
