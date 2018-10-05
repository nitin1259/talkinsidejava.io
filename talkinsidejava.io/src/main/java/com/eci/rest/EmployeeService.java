package com.eci.rest;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
	
	private static List<Employee> empList= new ArrayList<Employee>();
	
	Employee emp1 = new Employee(1, "Nitin", "Developer");
	Employee emp2 = new Employee(2, "Vipin", "RSS");
	Employee emp3 = new Employee(3, "Sachin", "Army");
	Employee emp4 = new Employee(4, "Amit", "Marketing");
	
	static{
		Employee emp1 = new Employee(1, "Nitin", "Developer");
		Employee emp2 = new Employee(2, "Vipin", "RSS");
		Employee emp3 = new Employee(3, "Sachin", "Army");
		Employee emp4 = new Employee(4, "Amit", "Marketing");
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
				
	}
	
	
	public Employee save(Employee emp){
		empList.add(emp);
		return emp;
	}
	
	public Employee update(Employee emp){
		Employee empOld = this.getEmployeebyName(emp.getName());
		empList.remove(empOld);
		empList.add(emp);
		return emp;
		
	}
	
	public void delete(int empId){
		Employee emp = this.getEmployeebyId(empId);
		empList.remove(emp);
	}
	
	public Employee getEmployeebyId(int empId){
		for(Employee emp : empList){
			if(emp.getId()==empId)
				return emp;
		}
		return null;
	}

	public Employee getEmployeebyName(String empName){
		for(Employee emp : empList){
			if(emp.getName().equals(empName));
				return emp;
		}
		return null;
	}
	
	public List<Employee> getEmployees(){
		return empList;
	}
}
