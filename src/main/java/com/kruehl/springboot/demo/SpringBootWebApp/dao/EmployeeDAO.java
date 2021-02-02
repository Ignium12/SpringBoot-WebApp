package com.kruehl.springboot.demo.SpringBootWebApp.dao;

import com.kruehl.springboot.demo.SpringBootWebApp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
