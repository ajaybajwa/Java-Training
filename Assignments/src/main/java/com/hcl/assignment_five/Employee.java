package com.hcl.assignment_five;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import javax.xml.transform.Source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	int id;
	String name;
	int age;
	String gender;
	String dept;
	int yearOfJoining;
	int salary;

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();

		list.add(new Employee(1, "John", 28, "Male", "IT", 2010, 80000));
		list.add(new Employee(2, "Ashley", 30, "Female", "IT", 2013, 50000));
		list.add(new Employee(3, "Kim", 26, "Female", "HR", 2011, 90000));
		list.add(new Employee(4, "Chris", 29, "Male", "Maintenance", 2020, 40000));
		list.add(new Employee(5, "Paul", 35, "Male", "Accounts", 2017, 60000));
		list.add(new Employee(6, "Karen", 30, "Female", "Maintenance", 2018, 60000));

		// Number of males and females in organization
		List<Employee> mList = list.stream().filter(e -> e.getGender().equals("Male"))// get Male gender objects
				.collect(Collectors.toList());// collect objects to create a list
		System.out.println("No. of males in the organization is :" + mList.size());

		List<Employee> fList = list.stream().filter(e -> e.getGender().equals("Female"))// get Female gender objects
				.collect(Collectors.toList());// collect objects to create a list
		System.out.println("No. of females in the organization is :" + fList.size());

		// Average age of males and females
		double mAvg = mList.stream().collect(Collectors.averagingInt(e -> e.getAge()));
		double fAvg = fList.stream().collect(Collectors.averagingInt(e -> e.getAge()));

		System.out.println("Average age of males: " + mAvg + "\nAverage age of females: " + fAvg);

		// Highest paid employee
		Employee maxSalEmp = list.stream().max(Comparator.comparing(e -> e.getSalary())).get();
		System.out.println("Highest paid employee is: " + maxSalEmp.getName() + ", $" + maxSalEmp.getSalary());

		// Employees who joined after 2015
		List<Employee> after2015EmpList = list.stream().filter(e -> e.getYearOfJoining() > 2015)
				.collect(Collectors.toList());
		Iterator<Employee> itr = after2015EmpList.iterator();
		while (itr.hasNext()) {
			System.out.println("Employees joined after 2015 are: " + itr.next().getName());
		}

		List<String> after2015Names = after2015EmpList.stream().map(e -> e.getName()).collect(Collectors.toList());
		System.out.println("Employees joined after 2015 are: " + after2015Names);

		// Senior most employee
		Employee seniorEmployee = list.stream().min(Comparator.comparing(e -> e.getYearOfJoining())).get();
		System.out.println("Senior most Employee is: " + seniorEmployee.getName());

		// Number of employees in each department
		Map<String, Long> DeptEmployeeCount = list.stream()
				.collect(Collectors.groupingBy(Employee::getDept, TreeMap::new, Collectors.counting()));
		DeptEmployeeCount.forEach((dep, count) -> System.out.println("Dept: " + dep + "  Count: " + count));

		// Number of males and females in Maintenance department
		Map<String, Long> maintGenderCount = list.stream().filter(e -> e.getDept().equals("Maintenance"))
				.collect(Collectors.groupingBy(g -> g.getGender(), TreeMap::new, Collectors.counting()));
		for (String s : maintGenderCount.keySet()) {
			System.out.println("Males and females in maintenace dept: " + s + ":" + maintGenderCount.get(s));
		}

		// Average salary of male and female employees
		Map<String, Double> avgSalByGender = list.stream().collect(
				Collectors.groupingBy(Employee::getGender, TreeMap::new, Collectors.averagingInt(Employee::getSalary)));
		avgSalByGender.forEach((gender, avgSal) -> System.out.println("" + gender + " : " + avgSal));

		// Employees under 30 and employees over 25
		List<Employee> under30Employees = list.stream().filter(e -> e.getAge() <= 30).collect(Collectors.toList());
		List<Employee> over25Employees = list.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
		System.out.println("Employees under 30: " + under30Employees);
		System.out.println("Employees over 25: " + over25Employees);

		// Names of employees in each department
		Map<String, List<Employee>> empNamesbyDept = list.stream().collect(Collectors.groupingBy(Employee::getDept));
		empNamesbyDept.forEach((dep, names) -> System.out
				.println("" + dep + " : " + names.stream().map(Employee::getName).collect(Collectors.toList())));
	}
}
