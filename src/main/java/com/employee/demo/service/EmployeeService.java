package com.employee.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.dao.EmployeeRepo;
import com.employee.demo.model.Employee;

@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepo repo;
	
	public Employee addEmp(Employee emp) {
		
		return repo.saveAndFlush(emp); 
	}
	
	public List<Employee> getAll() {
		
		return repo.findAll(); 
	}
	
public Optional<Employee> getById(Long id) {
		
		return repo.findById(id); 
	}
}
