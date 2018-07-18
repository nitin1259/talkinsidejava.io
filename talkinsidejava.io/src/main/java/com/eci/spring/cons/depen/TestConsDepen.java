package com.eci.spring.cons.depen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConsDepen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		/*Answers answers = (Answers)context.getBean("answers");
		
		System.out.println(answers);
		
		Question ques = (Question)context.getBean("question");
		System.out.println(ques);
		
		User user = (User)context.getBean("user");
		System.out.println(user);*/

		ConstructorDepen condepen = (ConstructorDepen)context.getBean("consDepen");
		System.out.println(condepen);
		
		EmployeeAnnotation emp = (EmployeeAnnotation)context.getBean("employeeAnnotation");
		System.out.println(emp);
	}

}
