package com.example.service;

import com.example.dao.StudentDao;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao dao;

    public void save(Student student) {
        dao.save(student);
    }

    public void listAll() {
        dao.findAll().forEach(System.out::println);
    }

}
