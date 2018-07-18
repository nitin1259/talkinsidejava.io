/**
 * 
 */
package com.eci.spring.basic.aop;

/**
 * @author nsingh
 *
 */
public interface ArithmeticOp{
	
	public int add();
	public int minus();
	public int multiply();
	public int division();
	
	public int add(int x, int y);
	public int minus(int x, int y);
	public int multiply(int x, int y);
	public int division(int x, int y);
	
}
