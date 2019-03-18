package com.springboot.app.springBootApp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.springBootApp.beans.Employee;
import com.springboot.app.springBootApp.repository.EmployeeDao;
import com.springboot.app.springBootApp.service.EmployeeService;



@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao empdao;
	
	@Override
	public Employee getEmployee(Long id) {

		return empdao.getEmployee(id);
		
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return empdao.saveEmployee(emp);
		
	}

}
