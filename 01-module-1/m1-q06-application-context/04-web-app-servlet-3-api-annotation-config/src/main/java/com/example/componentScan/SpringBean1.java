package com.example.componentScan;

import org.springframework.stereotype.Component;

@Component
public class SpringBean1 {
    public String getHello() {
        return "Hello from" + getClass().getName();
    }
}
