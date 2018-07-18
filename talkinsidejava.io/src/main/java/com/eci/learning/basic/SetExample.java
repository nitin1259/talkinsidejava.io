/**
 * 
 */
package com.eci.learning.basic;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author nsingh
 *
 */
public class SetExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Set<Integer> treeSet = new TreeSet<Integer>(new Compare());
		
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(1);
		

		System.out.println(treeSet);
		
		
		Set<String> mySet = new TreeSet<String>();
		mySet.add("BT");
		mySet.add("BT1");
		
		System.out.println("my Set"+ mySet);
		
		
		Set<Employee> strSet = new HashSet<Employee>();
		strSet.add(new Employee(1));
		strSet.add(new Employee(1));
		
		System.out.println("strSet"+ strSet);
	}

	static class Compare implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return 1;
		}
		
	}
	
	
}

class Employee{
	int k;
	
	public Employee(int k){
		this.k=k;
	}
	@Override
	public int hashCode(){
		return 1;
	}
	
	@Override
	public boolean equals(Object o){
		return false;
	}
	@Override
	public String toString() {
		return "Employee [k=" + k + "]";
	}
	
}