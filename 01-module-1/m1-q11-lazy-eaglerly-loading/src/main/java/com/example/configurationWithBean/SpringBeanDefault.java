package com.example.configurationWithBean;

import com.example.componentScan.PrototypeBeanButIjectedIntoSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SpringBeanDefault {

    public SpringBeanDefault() {
        System.out.println(getClass().getName() + ": constructor done!");
    }
}
