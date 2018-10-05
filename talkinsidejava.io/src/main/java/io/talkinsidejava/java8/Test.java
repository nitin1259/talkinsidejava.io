package io.talkinsidejava.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class Test {

	public static void main(String[] args) {
		Operation o = new Adder();
		System.out.println(o.operate(9, 7));

		// ananonyms class;
		Operation a = new Operation() {

			@Override
			public int operate(int x, int y) {
				return x + y;
			}
		};

		System.out.println(a.operate(2, 4));

		// lamda expression
		Operation ol = (int x, int y) -> {
			System.out.print("Sum : ");
			return x + y;
		};
		System.out.println(ol.operate(4, 6));

		// test on the Stringconverter interface
		String str = "My_India_is_great";
		doSomethingWithConverter((s) -> s.toUpperCase(), str);
		doSomethingWithConverter((s) -> s.substring(0, 3), str);
		doSomethingWithConverter((s) -> {
			return new StringBuffer(s).reverse().toString();
		}, str);

		// testing on the Emp class for list and lamda
		System.out.println("lamda exp on list example");
		testEmpClassWithLamda();

		// testing the method references.
		System.out.println("Testing method reference");
		doSomethingForMethodReferences((x, y) -> {
			return x + y;
		}, 30, 40);
		Math m = new Math();
		doSomethingForMethodReferences((x, y) -> m.add(x, y), 30, 40);
		doSomethingForMethodReferences(m::add, 30, 40);
		// for static ref
		doSomethingForMethodReferences((x, y) -> Math.subtract(x, y), 30, 40);
		doSomethingForMethodReferences(Math::subtract, 30, 40);

		// method reference to method of particular type.

		String[] names = { "Kumar", "Ramesh", "Nidhi", "John", "Sachin", "Kapil" };
		Arrays.sort(names, (s, t) -> t.compareTo(s));
		for (String name : names)
			System.out.println(name);
		System.out.println("method references");
		Arrays.sort(names, String::compareTo);
		for (String name : names)
			System.out.println(name);

		// Build in Function interfaces example;
		Emp emp = new Emp(1, "Nawaj", 80000, 10);
		checkEmp(e -> e.getSalary() > 50000, emp);

		System.out.println("checkToDoubleFucntion");
		checkToDoubleFucntion(e -> e.getSalary(), emp);
		checkToDoubleFucntion(Emp::getSalary, emp);

	}

	public static void doSomethingWithConverter(Converter con, String str) {
		System.out.println(con.convert(str));
	}

	public static void testEmpClassWithLamda() {
		List<Emp> empList = Arrays.asList(new Emp(1, "Nawaj", 80000, 10), new Emp(2, "Kamal", 50000, 20),
				new Emp(3, "Sandeep", 90000, 20), new Emp(4, "Govind", 95000, 20), new Emp(5, "Bataram", 30000, 30),
				new Emp(6, "Kartik", 70000, 10), new Emp(7, "Shomu", 150000, 30), new Emp(8, "Radha", 85000, 10));

		System.out.println("for each ");
		// empList.forEach(System.out::println);
		empList.forEach(emp -> System.out.println(emp));

		System.out.println("for each ended");

		Collections.sort(empList);
		Collections.sort(empList, (e1, e2) -> e1.compareTo(e2));
		// sorting on name in list
		// Collections.sort(empList, (e1,e2)->e1.getName().compareTo(e2.getName()));
		// sorting on multiple fields.
		// Collections.sort(empList, (e1,e2)->{return e1.getDeptId() - e2.getDeptId() ==
		// 0 ? e1.getName().compareTo(e2.getName()) : e1.getDeptId() -
		// e2.getDeptId();});
		for (Emp e : empList)
			System.out.println(e);
	}

	public static void doSomethingForMethodReferences(Operation o, int x, int y) {
		System.out.println(o.operate(x, y));
	}

	public static void checkEmp(Predicate<Emp> pr, Emp e) {
		if (pr.test(e))
			System.out.println("Valid Employee" + e);
		else
			System.out.println("invalid employee" + e);
	}

	public static void checkToDoubleFucntion(ToDoubleFunction<Emp> df, Emp emp) {
		System.out.println(df.applyAsDouble(emp));
	}
}