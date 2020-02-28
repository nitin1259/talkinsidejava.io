package com.java.learning.lamdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Greeter {

	public static void main(String [] args) {
		List<Person> people = Arrays.asList(
				new Person(1, "jonny", "gaddar", 30),
				new Person(3, "yuvraj", "Singh", 20),
				new Person(6, "Amit", "Mishra", 33),
				new Person(9, "sumit", "Rathi", 34),
				new Person(2, "ravi", "pawar", 12),
				new Person(7, "anil", "gill", 50)
			);
		
		// people.forEach(System.out::println);
		
		// people.stream().filter(p -> p.fname.startsWith("r")).forEach(System.out::println);
		
		people.stream().filter(p-> p.id%2 == 0).map(p-> p.lname="naveen").forEach(q-> System.out.println(q.getClass().getName()));
		
		List<String> strList =  people.stream().filter(p-> p.fname.length()>4).map(p-> p.fname).collect(Collectors.toCollection(ArrayList::new));
		
		Map<String, Integer> myMap = new ConcurrentHashMap<String, Integer>();
		
		System.out.println(1<<30);
		
		
	}
	
	
}


class Person{
	int id;
	String fname;
	String lname;
	int age;
	
	public Person(int id, String fname, String lname, int age) {
		this.id=id;
		this.fname=fname;
		this.lname=lname;
		this.age=age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
	
	
}
