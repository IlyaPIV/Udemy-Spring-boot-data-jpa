package com.udemy.spring.udemy_spring_data_jpa.controller;


import com.udemy.spring.udemy_spring_data_jpa.entity.Employee;
import com.udemy.spring.udemy_spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){

        return employeeService.getAllEmployees();
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){

        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

//    @PutMapping("/employees")
    @RequestMapping(value = "/employees",
                    produces = "application/json",
                    method = RequestMethod.PUT)
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

//    @DeleteMapping("/employees/{id}")
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);

        return "Employee with id = " + id + " was deleted.";
    }
}
