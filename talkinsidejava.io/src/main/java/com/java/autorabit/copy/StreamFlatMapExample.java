/**
 * 
 */
package com.java.autorabit.copy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author nisingh
 *
 */
public class StreamFlatMapExample {

	/**
	 * @param args
	 * 
	 * 	Stream<String[]>		-> flatMap ->	Stream<String>
		Stream<Set<String>>	-> flatMap ->	Stream<String>
		Stream<List<String>>	-> flatMap ->	Stream<String>
		Stream<List<Object>>	-> flatMap ->	Stream<Object>
		
		How flatMap() works :

		{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
		
		{ {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
	 */
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setName("Sachin");
		s1.addBook("the vinchi code");
		s1.addBook("the mahua");
		s1.addBook("fighter code");
		
		Student s2 = new Student();
		s2.setName("Puneet");
		s2.addBook("Anarkali");
		s2.addBook("Tauba");
		s2.addBook("fighter code");
		
		Student s3 = new Student();
		s3.setName("Kapil");
		s3.addBook("Jakarta");
		
		List<Student> list = Arrays.asList(s1,s2, s3);
		
		
		List<String> books = list.stream()
		.filter(s -> !s.name.equalsIgnoreCase("kapil"))
		.map(s -> s.getBooks())
		.flatMap(b-> b.stream())
		.distinct()
		.collect(Collectors.toList());
		
		books.forEach(System.out::println);

	}

}


class Student{
	String name;
	Set<String> books;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getBooks() {
		return books;
	}
	public void setBooks(Set<String> books) {
		this.books = books;
	}
	
	public void addBook(String book) {
		if(this.books==null) {
			this.books = new HashSet<String>();
		}
		this.books.add(book);
	}
	
}
