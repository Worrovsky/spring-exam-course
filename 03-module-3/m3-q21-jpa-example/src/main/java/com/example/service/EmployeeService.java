package com.example.service;


import com.example.dao.EmployeeDao;
import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao dao;

    @Autowired
    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public void showAll() {
        List<Employee> employees = (List<Employee>) dao.findAll();
        System.out.println("\nEmployees:");
        employees.forEach(System.out::println);
    }

    public void save(Employee employee) {
        dao.save(employee);
    }
}
