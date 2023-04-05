package com.arientech.employeemanegments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arientech.employeemanegments.service.EmployeeService;
import com.arientech.employeemanegments.entity.Employee;


@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// handler method to handle list students and return mode and view
	@GetMapping("/employees")
	public String listStudents(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}
	
	
	@GetMapping("/employees/new")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		return "create_employees";

	}
	
	@PostMapping("/employees")
	public String saveStudent(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}
	
	
	@PostMapping("/employees/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("employee") Employee emp,
			Model model) {

		// get student from database by id
		Employee existingStudent = employeeService.getEmployeeById(id);
		existingStudent.setId(id);
		existingStudent.setEmployeeName(emp.getEmployeeName());
		existingStudent.setAddress(emp.getAddress());
		existingStudent.setEmail(emp.getEmail());

		// save updated student object
		employeeService.updateEmployee(existingStudent);
		return "redirect:/employees";		
	}
	

	@GetMapping("/employees/{id}")
	public String deleteStudent(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}


}
