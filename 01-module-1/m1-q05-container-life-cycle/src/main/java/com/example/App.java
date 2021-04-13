package com.example;

import com.example.componentScan.AppConfig;
import com.example.componentScan.ServiceBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        ServiceBean bean = ctx.getBean(ServiceBean.class);
        bean.doWork();

        ctx.close();
    }
}
