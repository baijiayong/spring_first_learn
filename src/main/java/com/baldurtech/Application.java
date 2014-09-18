package com.baldurtech;

import com.baldurtech.controller.ContactController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application { 
    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        ContactController printer = context.getBean(ContactController.class);
        SpringApplication.run(Application.class);
    }
}