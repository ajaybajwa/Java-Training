package com.hcl.service;

import java.security.spec.DSAGenParameterSpec;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.model.Employee;
import com.hcl.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public List<Employee> getAllEmps() {
		return repo.findAll();
	}

	public Optional<Employee> getEmpById(int id) {
		return repo.findById(id);
	}

	public void deleteEmp(Integer id) {
		repo.deleteById(id);
	}

	public void addEmp(Employee emp) {
		repo.save(emp);
	}

	public void updateEmp(Integer id, Employee emp) {
		Employee employee = repo.findById(id).get();
		employee.setName(emp.getName());
		employee.setDesignation(emp.getDesignation());
		employee.setSalary(emp.getSalary());
		repo.save(employee);
	}

	/*
	 * public void updateEmp(String name, String designation, double salary, int id)
	 * { repo.updateById(name, designation, salary, id); }
	 */

	/*
	 * public void updateEmp(Employee emp) { repo.save(emp); }
	 */
}
