package com.udemy.spring.udemy_spring_data_jpa.service;


import com.udemy.spring.udemy_spring_data_jpa.dao.EmployeeRepository;
import com.udemy.spring.udemy_spring_data_jpa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee employee = null;
        Optional<Employee> emp = employeeRepository.findById(id);

        if (emp.isPresent()) {
            employee = emp.get();
        }

        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
