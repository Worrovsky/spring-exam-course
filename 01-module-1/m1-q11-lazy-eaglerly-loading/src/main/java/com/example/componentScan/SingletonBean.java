package com.example.componentScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonBean {
    @Autowired
    private PrototypeBeanButIjectedIntoSingleton beanButIjectedIntoSingleton;

    public SingletonBean() {
        System.out.println(getClass().getName() + ": constructor done!");
    }
}
