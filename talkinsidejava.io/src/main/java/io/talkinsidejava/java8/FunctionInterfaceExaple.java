package io.talkinsidejava.java8;

import java.util.function.Function;

public class FunctionInterfaceExaple {

	public static void main(String[] args) {
		
		Function<String, String> funStr1 = String::toUpperCase;
		Function<String, String> funStr2 = s -> new StringBuilder(s).reverse().toString();
		
		Function<String, String> funStr3 = s->s.substring(0, 3);
		
		Function<String, String> funTest1 = funStr2.compose(funStr3);
		System.out.println(funTest1.apply("India_is_My_country"));
		
		
		Function<String, String> funTest2 = funStr2.andThen(funStr3);
		System.out.println(funTest2.apply("India_is_My_country"));

		
		//--------------
		
		Function<Integer, Integer> doubler = a->a*2;
		Function<Integer, Integer> squarer = a->a*a;
		Function<Integer, Integer> adder = a->a+5;
		
		Function<Integer, Integer> op1 = doubler.compose(squarer).andThen(adder);
		System.out.println(op1.apply(5));
	}

}
