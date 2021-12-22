package com.employee.demo.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.employee.demo.model.Employee;
import com.employee.demo.service.EmployeeService;

@RestController
public class EmployeeCtrl {

	@Autowired
	EmployeeService service;
	
	@RequestMapping("/employeeRegPage")
	public ModelAndView employeeRegPage() {
		ModelAndView mav = new ModelAndView();
		Employee employee = new Employee();
		mav.addObject("employee", employee); //must map with thymeleaf object
		mav.setViewName("employee");
		return mav;
	}

	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(Employee employee) {
		ModelAndView mav = new ModelAndView();
		Employee emp = service.addEmp(employee);
		
		if(emp !=null) {
			mav.addObject("success", "success");
			mav.addObject("employee", employee);
			System.out.println(employee);
		}
		else
			mav.addObject("success", "fail");
		
		mav.setViewName("success");
		return mav;
	}
	
	@RequestMapping("/displayAll")
	public List<Employee> displayAll() {
		ModelAndView mav = new ModelAndView();
		List<Employee> emps = service.getAll();
		
		if(emps.size() > 0)
			mav.addObject("emps", emps);
		else
			mav.addObject("emps", "No record found!");
		
		System.out.println(emps);
		
		mav.setViewName("success");
		return emps;
	}
	
	@RequestMapping("/displayById/{id}")
	public Employee displayById(@PathVariable String id) {
		ModelAndView mav = new ModelAndView();
		Optional<Employee> emp = service.getById(Long.valueOf(id));
		
		if(emp != null)
			mav.addObject("emp", emp);
		else
			mav.addObject("emps", "No record found!");
		System.out.println(emp);
		mav.setViewName("success");
		
		return emp.get();
	}

}
