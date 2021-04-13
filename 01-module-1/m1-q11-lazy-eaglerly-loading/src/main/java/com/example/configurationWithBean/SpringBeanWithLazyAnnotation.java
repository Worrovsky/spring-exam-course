package com.example.configurationWithBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SpringBeanWithLazyAnnotation {

    public SpringBeanWithLazyAnnotation() {
        System.out.println(getClass().getName() + ": constructor done!");
    }
}
