package com.hms.dharani.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.dharani.persistence.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	//public Employee findbyEmployeeName(String EmployeeName);

	public void deleteById(int eid);

}
