/**
 * 
 */
package com.eci.learning.basic;

import java.io.IOException;


/**
 * @author nsingh
 *
 */

class Base{
	
	public void doSomething() throws RuntimeException{
		System.out.println("do Something : Base");
	}
	
	public static void doStuff(){
		
	}
}

class Sub extends Base{
	
	public void doSomething() throws ArrayIndexOutOfBoundsException{
		System.out.println("do Something : Sub");
	}
	
	public static void doStuff() throws RuntimeException{
		
	}
}

public class ExceptionExample {

	public static void main(String[] args) {
		
		try{
			doSomeActivity();
		}catch(Exception e){
			System.out.println("main method exception");
			e.printStackTrace();
		}finally{
			System.out.println("main finally");
		}
		
	}

	private static void doSomeActivity(){
		
		try{
			throw new IOException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("doSomeActivity finally");
		}
	}
}
