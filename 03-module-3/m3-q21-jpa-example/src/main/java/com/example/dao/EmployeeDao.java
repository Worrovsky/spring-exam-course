package com.example.dao;

import com.example.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeDao extends CrudRepository<Employee, Long> {
}
