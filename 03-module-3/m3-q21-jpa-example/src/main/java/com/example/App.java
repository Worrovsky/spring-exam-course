package com.example;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        ctx.registerShutdownHook();

        EmployeeService service = ctx.getBean(EmployeeService.class);

        service.save(new Employee(1L, "Bob", 5000));
        service.save(new Employee(2L, "Alice", 7000));
        service.showAll();
    }
}
