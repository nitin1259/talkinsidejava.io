/**
 * 
 */
package com.eci.spring.basic.aop;

import org.springframework.stereotype.Component;

/**
 * @author nsingh
 *
 */
@Component("arithmetic")
public class ArithmeticOpImpl implements ArithmeticOp{

	public int add() {
		System.out.println("i am in add method");
		return 2+1;
	}

	public int minus() {
		return 2-1;
	}

	@LoggableAnnotation
	public int multiply() {
		return 2*1;
	}

	public int division() {
		return 2/1;
	}

	public int add(int x, int y) {
		return x+y;
	}

	public int minus(int x, int y) {
		return x-y;
	}
	
	@LoggableAnnotation
	public int multiply(int x, int y) {
		return x*y;
	}

	public int division(int x, int y) {
		return x/y;
	}

}
