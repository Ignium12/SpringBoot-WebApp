package com.kruehl.springboot.demo.SpringBootWebApp.dao;

import com.kruehl.springboot.demo.SpringBootWebApp.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);


}
