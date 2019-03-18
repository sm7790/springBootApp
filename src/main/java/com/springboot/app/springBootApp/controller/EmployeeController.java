package com.springboot.app.springBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.springBootApp.beans.Employee;
import com.springboot.app.springBootApp.service.EmployeeService;



@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

	@GetMapping(path = "/hello")
	public String getEmployee(){
		
		return "Hello Employee";
		
	}
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value ="/getEmployee/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable("id") Long eId){
		Employee emp = new Employee();
		emp = empService.getEmployee(eId);
		return emp;
		
	}
	
	@RequestMapping(value ="/createEmployee", method = RequestMethod.POST)
	public Employee getEmployee(@RequestBody Employee emp){
		Employee e= new Employee();
		e = empService.createEmployee(emp);
		return e;
		
	}
}
