package com.autoconfig.example;

import com.autoconfig.example.bean.SomeInterface;
import com.autoconfig.example.bean.SomeInterfaceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAutoConfiguration {
    @Bean
    public SomeInterface someInterface() {
        return new SomeInterfaceImpl();
    }

}
