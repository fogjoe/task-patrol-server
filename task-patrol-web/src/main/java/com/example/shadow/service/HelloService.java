package com.example.shadow.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello() {
        return "hello from service layer";
    }
}
