package com.kruehl.springboot.demo.SpringBootWebApp.dao;

import com.kruehl.springboot.demo.SpringBootWebApp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee ", Employee.class);

        return (List<Employee>) query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {

        Employee employee1 = entityManager.merge(employee);

        employee.setId(employee1.getId());

    }

    @Override
    public void deleteById(int id) {

        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId",id);

        query.executeUpdate();
    }
}
