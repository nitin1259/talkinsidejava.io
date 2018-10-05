package com.eci.lrn.collectionProb;

import java.util.HashSet;
import java.util.Set;

public class SetBasicExample {

	public static void main(String[] args) {

		Set<Emp> empSet = new HashSet<>();
		empSet.add(new Emp(1, "Nitin"));
		empSet.add(new Emp(2, "Kapil"));
		empSet.add(new Emp(3, "Sachin"));
		
		System.out.println(new Emp(1, "Nitin").hashCode());
		System.out.println(new Emp(1, "Nitin").hashCode());
		/*System.out.println(empSet.size());
		empSet.forEach(emp ->{
			System.out.println("emp: "+ emp);
		});*/
	}

}

class Emp{
	private int empId;
	private String name;
	
	public Emp(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", name=" + name + "]";
	}	
	
}