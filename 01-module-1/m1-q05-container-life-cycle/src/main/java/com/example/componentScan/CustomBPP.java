package com.example.componentScan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBPP implements BeanPostProcessor {

    public CustomBPP() {
        System.out.println(getClass().getName() + ": construction done!");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(getClass().getName()
                + ": post process before init on "
                + beanName
                + " done!");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(getClass().getName()
                + ": post process after init on "
                + beanName
                + " done!");
        return bean;
    }
}
