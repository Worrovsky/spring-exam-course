package com.example.config.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomBFPP implements BeanFactoryPostProcessor {
    public CustomBFPP() {
        System.out.println(getClass().getName() + ": constructor done!");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        System.out.println(getClass().getName() + ": post process done.\n");
    }
}
