package com.a3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a3.application.models.Employee;
import com.a3.data.dao.EmployeeDAO;
import com.a3.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO emplD;
	
	@Transactional
	public void add(Employee employee) {
		emplD.add(employee);
	}

	@Transactional
	public void edit(Employee employee) {
		emplD.edit(employee);
	}

	@Transactional
	public Employee getEmployeeByUserName(String username) {
		return emplD.getEmployeeByUserName(username);
	}

	@Transactional
	public void delete(Employee employee) {
		emplD.delete(employee);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		return emplD.getAllEmployees();
	}

	@Transactional
	public Employee getEmployeeByPNC(long employeePNC) {
		return emplD.getEmployeeByPNC(employeePNC);
	}

	@Transactional
	public List<Employee> getAllDoctors() {
		return emplD.getAllDoctors();
	}

}
