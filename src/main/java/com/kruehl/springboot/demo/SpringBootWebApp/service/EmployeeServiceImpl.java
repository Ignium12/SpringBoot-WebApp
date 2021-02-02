package com.kruehl.springboot.demo.SpringBootWebApp.service;

import com.kruehl.springboot.demo.SpringBootWebApp.dao.EmployeeRepository;
import com.kruehl.springboot.demo.SpringBootWebApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override

    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;
        if(result.isPresent()){
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Override

    public void save(Employee employee) {

        if(employeeRepository.existsById(employee.getId())){
            employeeRepository.save(employee);
        } else {
            throw new RuntimeException("The id you want to update (" + employee.getId() + ") does not exist in the database");
        }

    }

    @Override

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
