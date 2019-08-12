package com.privatchat.privatchat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Reciever {
    @Autowired
    AnnotationConfigApplicationContext context;

    public void receiveMessage(String message){
        System.out.println("Received <" + message + ">");
        this.context.close();
    }
}
