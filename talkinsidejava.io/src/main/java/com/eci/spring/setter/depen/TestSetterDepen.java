/**
 * 
 */
package com.eci.spring.setter.depen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nsingh
 *
 */
public class TestSetterDepen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("setterspring.xml");
		
		/*Answer ans = (Answer)context.getBean("answer");
		System.out.println(ans);
		
		Question ques = (Question)context.getBean("question");
		System.out.println(ques);*/
		
		User user = (User)context.getBean("user");
		System.out.println(user);
		
		Answer conAns = (Answer)context.getBean("conAnswer");
		System.out.println(conAns);

	}
}
