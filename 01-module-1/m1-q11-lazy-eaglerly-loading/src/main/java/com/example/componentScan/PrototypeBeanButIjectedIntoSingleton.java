package com.example.componentScan;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBeanButIjectedIntoSingleton {

    public PrototypeBeanButIjectedIntoSingleton() {
        System.out.println(getClass().getName() + ": constructor done!");
    }
}
