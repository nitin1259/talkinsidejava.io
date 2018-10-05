/**
 * 
 */
package com.eci.spring.basic;

/**
 * @author nsingh
 *
 */
public class Employees {
	
	private int empId;
	
	private String name;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employees [empId=" + empId + ", name=" + name + "]";
	}
	
	

}
