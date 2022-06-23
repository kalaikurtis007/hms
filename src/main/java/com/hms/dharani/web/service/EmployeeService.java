package com.hms.dharani.web.service;

import java.util.List;

import com.hms.dharani.persistence.entity.Employee;
import com.hms.dharani.web.error.EmployeeNotFoundException;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> fetchEmployeeList();

	void deleteEmployeeById(int eid) throws EmployeeNotFoundException;

	Employee updateEmployee(int eid, Employee employee) throws EmployeeNotFoundException;

	Employee fetchEmployeeById(int eid);

}
