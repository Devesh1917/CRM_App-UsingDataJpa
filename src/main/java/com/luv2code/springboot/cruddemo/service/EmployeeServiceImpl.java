package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository theEmployeeRepository;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.theEmployeeRepository=theEmployeeRepository;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		return theEmployeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = theEmployeeRepository.findById(theId);
		Employee theEmployee=null;
		if (result.isPresent()) {
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("Employee not found for Id : "+ theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		theEmployeeRepository.save(theEmployee);
	}

	@Override
	public void delete(int theId) {
		theEmployeeRepository.deleteById(theId);
		
	}

}
