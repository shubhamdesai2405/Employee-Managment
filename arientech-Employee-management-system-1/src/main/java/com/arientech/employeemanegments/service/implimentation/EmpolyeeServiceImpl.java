package com.arientech.employeemanegments.service.implimentation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arientech.employeemanegments.entity.Employee;
import com.arientech.employeemanegments.repo.EmployeeRepository;
import com.arientech.employeemanegments.service.EmployeeService;


@Service
public class EmpolyeeServiceImpl implements EmployeeService {
	
	
	private EmployeeRepository employeeRepository;

	public EmpolyeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();	
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	

}
