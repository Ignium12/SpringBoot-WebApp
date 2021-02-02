package com.kruehl.springboot.demo.SpringBootWebApp.dao;

import com.kruehl.springboot.demo.SpringBootWebApp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private final EntityManager entityManager;

    @Autowired // entitymanager is automatically created by spring boot
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get the current hibernate session
        Session session = entityManager.unwrap(Session.class);

        // get the employee
        Employee employee = session.get(Employee.class, id);
        // return the employee
        return employee;

    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("DELETE FROM Employee where id=:employeeId");
        query.setParameter("employeeId",id);

        query.executeUpdate();
    }
}
