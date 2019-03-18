package com.springboot.app.springBootApp.service;

import com.springboot.app.springBootApp.beans.Employee;

public interface EmployeeService {
	
	Employee getEmployee(Long id);
	
	Employee createEmployee(Employee emp);

}
