/**
 * 
 */
package com.eci.spring.basic.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nsingh
 *
 */
public class TestAOP {
	
	public static void main(String [] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springAOP.xml");
		
		//ArithmeticOp arithmetic = context.getBean("arithmetic", ArithmeticOpImpl.class);
		
		ArithmeticOp arithmetic = context.getBean("arithmetic", ArithmeticOp.class);
		
		//System.out.println("no args add: "+arithmetic.add());
		System.out.println("no args minus: "+arithmetic.minus());
		System.out.println("no args mulitply: "+arithmetic.multiply());
		System.out.println("with args mulitply: "+arithmetic.multiply(10,23));
		//System.out.println("no args division: "+arithmetic.division(10,0));
		//System.out.println("with args add: "+arithmetic.add(4,3));
		
	}

}
