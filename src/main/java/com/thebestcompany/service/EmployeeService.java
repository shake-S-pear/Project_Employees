package com.thebestcompany.service;

import com.thebestcompany.entity.Employee;
import com.thebestcompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> listAll() {
		return employeeRepository.findAll();
	}

	public Page<Employee> listAll(int pageNum, String sortField, String sortDir) {

		Pageable pageable = PageRequest.of(pageNum - 1, 5,
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
						: Sort.by(sortField).descending()
		);

		return employeeRepository.findAll(pageable);
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee get(long id) {
		return employeeRepository.findById(id).get();
	}
	
	public void delete(long id) {
		employeeRepository.deleteById(id);
	}
}
