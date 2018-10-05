/**
 * 
 */
package com.eci.spring.basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author nsingh
 *
 */
public class Test {

	
	
	public static void main(String [] args){
	
		Resource resource = new ClassPathResource("spring.xml");
		BeanFactory beanfac = new XmlBeanFactory(resource);
		
		
		ApplicationContext context  =  new ClassPathXmlApplicationContext("spring.xml");
		Employees emp = (Employees)context.getBean("emp");
		
		System.out.println("Employee: "+emp);
	}
	
	
	
}
