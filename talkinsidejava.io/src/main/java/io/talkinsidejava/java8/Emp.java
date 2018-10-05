/**
 * 
 */
package io.talkinsidejava.java8;

/**
 * @author sinni14
 *
 */
public class Emp implements Comparable<Emp>{
	private int empId;
	private String name;
	private long salary;
	private int deptId;
	public int getEmpId() {
		return empId;
	}
	
	
	public Emp(int empId, String name, long salary, int deptId) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
	}


	public Emp() {
		super();
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
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + ", salary=" + salary + ", deptId=" + deptId + "]";
	}


	@Override
	public int compareTo(Emp o) {
		if(o!=null) {
		if(this.salary > o.salary) return 1;
		else if(this.salary < o.salary) return -1;
		else return 0;
		}else return 0;
		
	}
	
	

}
