/**
 * 
 */
package com.eci.learning.java8.lamadas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author nsingh
 *
 */
public class TestLamdaOnPersonsList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Sachin", "Chahal", 24),
				new Person("Vineet", "Kumar", 34), new Person("Vishesh",
						"Chahal", 28), new Person("Ashish", "Chahal", 37),
				new Person("Ashish", "Chahal", 27), new Person("Vipin",
						"Chaudhary", 24), new Person("Nitin", "Singh", 29),
				new Person("Mohit", "Kumar", 37));

		// people.add(new Person("Mohit", "Kumar", 37));
		System.out.println("print what added into list");
		printPersons(people);
		//or
		printFilterPersons(people, p->true);

		// 1. sorting the list on last name and first name together
		Collections.sort(people, (Person p1, Person p2) -> {
			if (p1.getLastName().compareTo(p2.getLastName()) == 0) {
				if (p1.getFirstName().compareTo(p2.getFirstName()) == 0) {
					return p1.getAge().compareTo(p2.getAge());
				} else
					return p1.getFirstName().compareTo(p2.getFirstName());
			} else {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});

		// 2. method to print the list of person
		System.out.println("print after sorting on lastname and first name");
		printPersons(people);

		// 3. method to filter out the person based on condition.
		System.out.println("filter people wtih C");
		printFilterPersons(people, p->p.getLastName().startsWith("Ku") || p.getFirstName().startsWith("V") );

	}

	private static void printFilterPersons(List<Person> people, Condition condition) {
		people.forEach(p -> {
			if (condition.isPrintPerson(p))
				System.out.println(p);
		});

	}

	private static void printPersons(List<Person> people) {
		people.forEach(p -> System.out.println(p));

	}

}


interface Condition{
	boolean isPrintPerson(Person p);
}