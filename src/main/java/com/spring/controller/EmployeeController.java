package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.pojo.Employee;
import com.spring.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl imp;
	
	//display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		List<Employee> list = imp.getAllEmployees();
		model.addAttribute("listofemployee", list);
		return "index";
	}

	@GetMapping("/NewEmployee")
	public String viewNewEmployee(Model model)
	{
		Employee l =new Employee();
		model.addAttribute("employee", l);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee emp)
	{
		imp.save(emp);
		return "redirect:/";
	}
	
	@GetMapping("/updateForm/{id}")
	public String getEmployee(@PathVariable (value="id") int id,Model model)
	{
		//int id1=Integer.parseInt(id);
		//set data to employee object
		Employee byId = imp.getById(id);
		//set employee as a model object to prepopulate form
		model.addAttribute("employee",byId);
		return "new_employee";
	}
	@GetMapping("/deleteForm/{id}")
	public String deleteEmployee(@PathVariable(value="id") int id)
	{
		imp.deleteById(id);
		return "redirect:/";
	}
}
