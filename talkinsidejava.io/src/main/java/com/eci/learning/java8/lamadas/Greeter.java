/**
 * 
 */
package com.eci.learning.java8.lamadas;

/**
 * @author nsingh
 *
 */
public class Greeter {

	public void greet(){
		System.out.println("Hello world Greeter... !");
	}
	
	public void greet(Greeting greeting){
		greeting.perform();
	}
	
	public static void main(String [] args){
		
		//older way of imlementation
		Greeter greeter = new Greeter();
		Greeting helloGreeting = new HelloWorldGreeting();
		greeter.greet(helloGreeting);
		
		//new way with java 8
		greeter.greet(()->System.out.println("Sachin tendulkar"));
		
		LamdaExample1 lamExp1 = ()-> System.out.println("lamda example one");
		lamExp1.doSomething();
		
		LamdaExample2 lamExp2 = (s1,s2)-> {
			return s1.length()+s2.length();
		};
		System.out.println(lamExp2.doSomething("Habibi Habibi","khawja khawjaja"));
		
	}
}

@FunctionalInterface
interface LamdaExample1{
	void doSomething();
	default int calculateSum(int a, int b){
		return a+b;
	}
	default int calculateDif(int a, int b){
		return a-b;
	}
	static int calStatic(){
		return 5;
	}
	static int caluclateStatic(){
		return 5;
	}
	
}
@FunctionalInterface
interface LamdaExample2{
	int doSomething(String firstName, String lastName);
}