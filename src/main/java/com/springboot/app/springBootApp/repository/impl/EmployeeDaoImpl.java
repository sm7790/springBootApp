package com.springboot.app.springBootApp.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.app.springBootApp.beans.Employee;
import com.springboot.app.springBootApp.repository.EmployeeDao;



@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Employee getEmployee(Long id) {
		return getCurrentSession().find(Employee.class, id);
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		return (Employee) getCurrentSession().save(emp);
	}
	
	
	

	
	
	protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
