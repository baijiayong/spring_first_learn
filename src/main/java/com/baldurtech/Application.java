package com.baldurtech;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application { 
    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        ContactController printer = context.getBean(ContactController.class);
        printer.printMessage();
    }
}