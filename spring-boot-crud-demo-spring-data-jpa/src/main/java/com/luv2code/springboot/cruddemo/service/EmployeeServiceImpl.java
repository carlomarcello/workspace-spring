package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {	
		this.employeeRepository = theEmployeeRepository;
	}

	@Override
	// @Transactional, no need, provided out of the box
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	// @Transactional, no need, provided out of the box
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	// @Transactional, no need, provided out of the box
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	// @Transactional, no need, provided out of the box
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
