/**
 * 
 */
package com.eci.lrn.collectionProb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * @author nsingh
 *http://stackoverflow.com/questions/13022073/adding-objects-into-alphabetically-ordered-array-list
 */
public class InsertObjectInArrayListSortedOrder {

	/**
	 * @param args
	 * this program is to define the 
	 */
	public static void main(String[] args) {
		List<Employee> sortingList = new ArrayList<Employee>();
		
		Employee emp1 = new Employee(1,"Nitin","Bangalore");
		insetedObjInSortedOrder(sortingList, emp1);
		Employee emp2 = new Employee(4,"Sachin","Delhi");
		insetedObjInSortedOrder(sortingList, emp2);
		for(Employee emp:sortingList){
			System.out.println(emp);
		}
		System.out.println("new");
		Employee emp3 = new Employee(2,"Vipin","Moradabad");
		insetedObjInSortedOrder(sortingList, emp3);
		Employee emp4 = new Employee(8,"Vishesh","Gurgaon");
		for(Employee emp:sortingList){
			System.out.println(emp);
		}
		System.out.println("new");
		insetedObjInSortedOrder(sortingList, emp4);
		Employee emp5 = new Employee(5,"Kapil","Lodhipur");
		insetedObjInSortedOrder(sortingList, emp5);
		
		for(Employee emp:sortingList){
			System.out.println(emp);
		}
	}
	
	
	public static void insetedObjInSortedOrder(List<Employee> sortingList, Employee emp){
		
		int index = Collections.binarySearch(sortingList, emp);
		System.out.println("index is: "+index);
		if(index<0)
			index=(index*-1)-1;
		sortingList.add(index,emp);
	}
	
}

class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private String address;
	
	public Employee(int id, String name, String address){
		this.id=id;
		this.name=name;
		this.address=address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int compareTo(Employee emp) {
		// TODO Auto-generated method stub
		if(this.id > emp.id){
			return 1;
		}else if(this.id<emp.id)
			return -1;
			else
		return 0;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	
	
}