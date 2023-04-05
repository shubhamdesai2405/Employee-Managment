package com.arientech.employeemanegments.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arientech.employeemanegments.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

