package com.example.componentScan;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Lazy
public class SingletonBeanWithLazyAnnotation {

    public SingletonBeanWithLazyAnnotation() {
        System.out.println(getClass().getName() + ": constructor done!");
    }
}
