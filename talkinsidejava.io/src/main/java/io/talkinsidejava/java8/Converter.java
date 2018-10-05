package io.talkinsidejava.java8;

@FunctionalInterface
public interface Converter {
	// take string convert into different string
	// 1. convert upper case
	// 2. print first 3 char
	// 3. print reverse char
	public String convert(String s);
	
	public static void doConvert() {
		System.out.println("do convert method");
	}
	default void methodConver() {
		System.out.println("method Convert method");
	}

}
