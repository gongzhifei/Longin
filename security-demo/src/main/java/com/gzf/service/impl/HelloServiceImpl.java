package com.gzf.service.impl;

import com.gzf.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String message) {
        return message;
    }
}
