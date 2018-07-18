/**
 * 
 */
package com.eci.lrn.concept.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nsingh
 *
 */
public class BasicTests {

	/**
	 * @param args
	 */
	BasicTests(){
		System.out.println("cons");
	}
	public void BasicTests(int i){
		System.out.println("cons");
	}
	public static int BasicTests(){
		return 0;
	}
	
	@SuppressWarnings("finally")
	public static int doSomething(){
		try{
			//throw new Exception();
			return 3;
		}catch(Exception e){
			//return 4;
		}finally{
			return 6;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("u10/23".substring(0,"u10/23".indexOf('/')));
		
		String name="sachin";
		
		System.out.println("name is "+name);
		System.out.println("doSomething: "+doSomething());
		
		
		//this one is to check the hashcode implementation
		//checkedHashSetFunctionality();

	}
	
	
	
	public static void checkedHashSetFunctionality(){
		Set<Employee> strSet = new HashSet<Employee>();
		for(int i=0;i<100;i++){
			strSet.add(new Employee(i, "Nitin"));
		}
		System.out.println("Size: "+strSet.size());
		System.out.println(strSet.toString());
	}

	static class Employee{
		int id;
		String name;
		public Employee(int id, String name){
			this.id=id;
			this.name=name;
		}
		
		@Override
		public int hashCode(){
			//return 31*id;
			return id;
		}

		@Override
		public boolean equals(Object arg0) {
			// TODO Auto-generated method stub
			//return super.equals(arg0);
			//return this.name.equalsIgnoreCase(((Employee)arg0).name) ;
			return true;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + "]";
		}
		
		
	}
}
