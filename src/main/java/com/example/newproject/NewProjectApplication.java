package com.example.newproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class NewProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewProjectApplication.class, args);
    }

}
