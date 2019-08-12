package com.privatchat.privatchat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
public class Controller {

    @GetMapping("Hi")
    public String heloo() throws IOException, TimeoutException {
        return "Helllooooooo 1.0";
    }
}


