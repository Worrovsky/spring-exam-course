package com.example.configurationWithBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@Lazy
public class LazyBeansConfig {

    @Bean
    @Lazy
    public SpringBeanWithLazyAnnotation springBeanWithLazyAnnotation() {
        return new SpringBeanWithLazyAnnotation();
    }

    @Bean
    public SpringBeanDefault springBeanDefault() {
        return new SpringBeanDefault();
    }

    @Bean
    @Scope("prototype")
    public SpringBeanWithScopePrototype springBeanWithScopePrototype() {
        return new SpringBeanWithScopePrototype();
    }
}
