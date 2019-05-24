package com.app.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.app.example.model.*;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

    public List<Employee> findAll();
	public Employee findEmployeeByid(Integer id);
	//public Employee updateEmployeeByid(Integer id);
}
