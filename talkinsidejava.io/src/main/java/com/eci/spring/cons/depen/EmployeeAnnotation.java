/**
 * 
 */
package com.eci.spring.cons.depen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nsingh
 *
 */

@Component
public class EmployeeAnnotation {
	
	private int id;
	
	private Question question;

	@Override
	public String toString() {
		return "EmployeeAnnotation [id=" + id + ", ques=" + question + "]";
	}
	
	

}
