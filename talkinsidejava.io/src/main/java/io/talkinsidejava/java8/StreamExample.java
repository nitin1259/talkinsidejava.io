package io.talkinsidejava.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {

	public static void main(String[] args) {
		List<Books> books = new ArrayList<>();
		books.add(new Books("java", 2010, new Author("Radha", 10)));
		books.add(new Books("C#", 2006, new Author("Govind", 3)));
		books.add(new Books("ReactJS", 2014, new Author("Nawaz", 16)));
		books.add(new Books("Angular", 2011, new Author("Kartik", 23)));
		books.add(new Books("NodeJs", 2007, new Author("Bataram", 4)));
		books.add(new Books("HTML", 1998, new Author("Shomu", 12)));
		books.add(new Books("javascript", 2001, new Author("Sandeep", 1)));
		books.add(new Books("ReactJS", 2019, new Author("Nawaz", 16)));

		books.stream().filter(b -> b.getYear() < 2010).map(Books::getAuther).filter(Objects::nonNull)
				.map(Author::getName).forEach(System.out::println);
		long c = books.stream().filter(b -> b.getYear() < 2010).map(Books::getAuther).filter(Objects::nonNull)
				.map(Author::getName).count();
		System.out.println("count : " + c);

		double count = books.stream().filter(b -> b.getYear() > 2000).mapToDouble(Books::getYear).sum();
		System.out.println("cou : " + count);

		books.stream().filter(b -> b.getAuther().getCountOfBooks() > 5).map(Books::getName).sorted()
				.forEach(System.out::println);

		books.stream().sorted(Comparator.comparing(Books::getYear)).forEach(System.out::println);

		System.out.println("find first-----------> ");
		Optional<Books> opt = books.stream().filter(b -> b.getYear() > 2010).findFirst();
		System.out.println(opt.get());

		System.out.println("peek -----------> ");
		books.stream().peek(System.out::println).filter(b -> b.getAuther().getCountOfBooks() > 5).peek(b -> {
			System.out.println("new peek");
		}).peek(System.out::println).map(Books::getName).sorted().forEach(System.out::println);

		/*
		 * System.out.println("collect -----------> "); Map<String, Author> map=
		 * books.stream().collect(Collectors.toMap(Books::getName, Books::getAuther));
		 * map.forEach((k,v) ->{System.out.println("key is: " + k + " value is: "+
		 * v);});
		 * 
		 * System.out.println("collect -----------> "); Map<String, Books> bookMap=
		 * books.stream().collect(Collectors.toMap(Books::getName, e->e));
		 * bookMap.forEach((k,v) ->{System.out.println("key is: " + k + " value is: "+
		 * v);});
		 * 
		 * 
		 * System.out.println("collect -----------> "); Map<String, Books> bookMap2=
		 * books.stream().collect(Collectors.toMap(Books::getName,
		 * Function.identity())); bookMap2.forEach((k,v)
		 * ->{System.out.println("bookMap2 key is: " + k + " value is: "+ v);});
		 */
		// handling the duplicate key .
		Map<String, Books> bookMap3 = books.stream()
				.collect(Collectors.toMap(Books::getName, Function.identity(), (a, b) -> a));
		bookMap3.forEach((k, v) -> {
			System.out.println("bookMap3 key is: " + k + " value is: " + v);
		});

		// want the a sorting or treemap
		Map<String, Books> bookMap4 = books.stream()
				.collect(Collectors.toMap(Books::getName, Function.identity(), (a, b) -> a, TreeMap::new));
		bookMap4.forEach((k, v) -> {
			System.out.println("bookMap4 key is: " + k + " value is: " + v);
		});

		// groupby funtion on the streams

	}

}

class Books implements Comparable<Books> {
	private String name;
	private int year;
	private Author auther;

	public Books(String name, int year, Author auther) {
		super();
		this.name = name;
		this.year = year;
		this.auther = auther;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Author getAuther() {
		return auther;
	}

	public void setAuther(Author auther) {
		this.auther = auther;
	}

	@Override
	public String toString() {
		return "Books [name=" + name + ", year=" + year + ", auther=" + auther + "]";
	}

	@Override
	public int compareTo(Books o) {
		return this.getName().compareTo(o.getName());
	}

}

class Author {
	private String name;
	private int countOfBooks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountOfBooks() {
		return countOfBooks;
	}

	public void setCountOfBooks(int countOfBooks) {
		this.countOfBooks = countOfBooks;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", countOfBooks=" + countOfBooks + "]";
	}

	public Author(String name, int countOfBooks) {
		super();
		this.name = name;
		this.countOfBooks = countOfBooks;
	}

}