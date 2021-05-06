package com.example.dao;

import com.example.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {
}
