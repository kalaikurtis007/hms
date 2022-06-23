package com.hms.dharani.web.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.hms.dharani.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.dharani.persistence.entity.Employee;

import com.hms.dharani.web.error.EmployeeNotFoundException;
import com.hms.dharani.persistence.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}

	@Override
	public List<Employee> fetchEmployeeList() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteEmployeeById(int eid) throws EmployeeNotFoundException {
		repository.deleteById(eid);
		Optional<Employee> employee = repository.findById(eid);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee Not Available");
		} else {
			repository.deleteById(eid);
		}
	}

	@Override
	public Employee updateEmployee(int eid, Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> employeeobj = repository.findById(eid);
		Employee empDB = new Employee();
		/*if (employeeobj.isPresent()) {
			// depDB = repository.findById(did);
			int id = 0;
			try {
				id = employeeobj.get().getEmployeeId();
			} catch (NullPointerException e) {
				id = 2;
			}
			empDB.setEmployeeId(id);
			if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
				empDB.setEmployeeName(employee.getEmployeeName());
			}
			if (Objects.nonNull(employee.getEmployeeAge()) && employee.getEmployeeAge() < 0) {
				empDB.setEmployeeAge(employee.getEmployeeAge());
				System.out.println(employee.getEmployeeAge());
			}
			if (Objects.nonNull(employee.getEmployeeMobile()) && !"".equalsIgnoreCase(employee.getEmployeeMobile())) {
				empDB.setEmployeeMobile(employee.getEmployeeMobile());
				System.out.println(employee.getEmployeeMobile());
			}

			return repository.save(empDB);
		} else {
			throw new EmployeeNotFoundException("Employee Not available");
		}*/
		return null;
	}

	@Override
	public Employee fetchEmployeeById(int eid) {
		// TODO Auto-generated method stub
		return (Employee) repository.findById(eid).get();
	}

}
