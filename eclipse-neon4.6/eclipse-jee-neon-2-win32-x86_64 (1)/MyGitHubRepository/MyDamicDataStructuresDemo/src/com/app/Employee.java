package com.app;

public class Employee implements Comparable<Employee>{

	private Integer id;
	private String name;
	private double salary;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(Integer id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [*-> id=" + id + ", name=" + name + ", salary=" + salary
				+ "]";
	}
	
	@Override
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		if (this.salary == emp.salary){
			return 0;
		}else if(this.salary >emp.salary) {
			return 1;
		}else 
		return -1;
	}
}
