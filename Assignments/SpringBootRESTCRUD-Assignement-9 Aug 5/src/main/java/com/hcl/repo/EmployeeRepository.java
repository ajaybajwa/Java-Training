package com.hcl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hcl.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	/*
	 * @Modifying
	 * 
	 * @Query("update Employee set name = ?1, designation = ?2, salary = ?3 where empid = ?4"
	 * ) void updateById(String name, String designation, double salary, int empid
	 * );
	 */
}
