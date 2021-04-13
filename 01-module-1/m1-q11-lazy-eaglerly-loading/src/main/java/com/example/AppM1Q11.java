package com.example;

import com.example.componentScan.*;
import com.example.configurationWithBean.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppM1Q11 {
    public static void main(String[] args) {

        System.out.println("Context #1 created (@ComponentScan):");
        AnnotationConfigApplicationContext ctx1 = new AnnotationConfigApplicationContext(ConfigComponentScan.class);

        System.out.println("not instantiated: " + PrototypeBean.class.getName());
        System.out.println("not instantiated: " + SingletonBeanWithLazyAnnotation.class.getName());

        ctx1.close();
        System.out.println("Context #1 closed.\n");


        System.out.println("Context #2 created (@ComponentScan(lazyInit = true)):");
        AnnotationConfigApplicationContext ctx2 =
                new AnnotationConfigApplicationContext(ConfigComponentScanWithLazyInitTrue.class);
        System.out.println("There aren't instantiated beans:");
        System.out.println("     @ComponentScan(lazyInit = true)");

        ctx2.close();
        System.out.println("Context #2 closed.\n");

        System.out.println("Context #3 created (@Configuration):");
        AnnotationConfigApplicationContext ctx3 =
                new AnnotationConfigApplicationContext(BeansConfig.class);
        System.out.println("not instantiated: " + SpringBeanWithLazyAnnotation.class.getName());
        System.out.println("not instantiated: " + SpringBeanWithScopePrototype.class.getName());

        ctx3.close();
        System.out.println("Context #3 closed.\n");

        System.out.println("Context #4 created (@Configuration + @Lazy):");
        AnnotationConfigApplicationContext ctx4 =
                new AnnotationConfigApplicationContext(LazyBeansConfig.class);
        System.out.println("not instantiated: " + SpringBeanDefault.class.getName());
        System.out.println("not instantiated: " + SpringBeanWithLazyAnnotation.class.getName());
        System.out.println("not instantiated: " + SpringBeanWithScopePrototype.class.getName());

        ctx4.close();
        System.out.println("Context #4 closed.\n");


    }
}
