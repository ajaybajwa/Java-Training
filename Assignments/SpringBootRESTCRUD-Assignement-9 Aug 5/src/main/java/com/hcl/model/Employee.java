package com.hcl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emp_july")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Represents as primary key
    private int empid;
    private String name;
    private String designation;
    private double salary;
}

