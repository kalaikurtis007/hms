package com.hms.dharani.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.dharani.persistence.entity.Employee;

import com.hms.dharani.web.error.EmployeeNotFoundException;
import com.hms.dharani.web.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee employeeService(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);


    }

    //getallRecords
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList() {
        return employeeService.fetchEmployeeList();
    }

    //deleteRecord by id 
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") int eid) throws EmployeeNotFoundException {
        employeeService.deleteEmployeeById(eid);
        return "Department is deleted";
    }
    //get Department by Id
    /*
     * @GetMapping("/employees/{id}") public Employee
     * fetchEmployeeById(@PathVariable("id")int eid)throws
     * EmployeeNotFoundException{ return employeeService.fetchDepartmentById(eid); }
     */

    //update record
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") int eid, @RequestBody Employee employee) throws EmployeeNotFoundException {
        return employeeService.updateEmployee(eid, employee);
    }
}

