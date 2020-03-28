/**
 * 
 */
package com.java.autorabit.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nisingh
 *
 */
public class StreamPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(new Employee(1, "Sachin", 10000.0),
				new Employee(2, "Kapil", 20000.0),
				new Employee(3, "Kundan", 30000.0),
				new Employee(5, "Deepak", 33000.0),
				new Employee(4, "Amit", 40000.0));

		//print the containing list;
		// empList.forEach(System.out::println);
		
		//change get list of Id of employees from emp list
		List<Integer> list = empList.stream().map(e-> e.getId()).collect(Collectors.toList());
		
		
		// get the employee list from the ids;
		List<Employee> newList = list.stream().map(EmployeeRepository::findEmployeeById).filter(e-> e.getSalary()>20000).collect(Collectors.toList());
		
		// newList.forEach(e-> System.out.println(e));
		
		
		// get streams into array
		Employee [] empArr = newList.stream().toArray(Employee[]::new);
		
		for(Employee e: empArr) System.out.println(e);
		
	}
	
	
	

}

class EmployeeRepository{
	static List<Employee> empList = new ArrayList<>();
	static {
		empList.add(new Employee(1, "Sachin", 10000.0));
		empList.add(new Employee(2, "Rohit", 20000.0));
		empList.add(new Employee(3, "Vipin", 30000.0));
		empList.add(new Employee(4, "Nitin", 40000.0));
		empList.add(new Employee(5, "Deepak", 33000.0));
	}
	
	
	
	
	public static Employee findEmployeeById(int id) {
		
		Employee emp = empList.stream().filter(e-> e.getId() == id).findAny().orElseThrow(()-> new IllegalArgumentException());
		return emp;
	}
}

class Employee{
	
	private int id;
	private String name;
	private double salary;
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	public void salaryIncrement(double percent) {
		this.salary = this.salary + (this.salary * (percent/100));
	}
	
}
