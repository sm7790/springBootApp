package com.springboot.app.springBootApp.repository;

import com.springboot.app.springBootApp.beans.Employee;

public interface EmployeeDao {
	
	Employee getEmployee(Long id);
	
	Employee saveEmployee(Employee emp);

	
}
