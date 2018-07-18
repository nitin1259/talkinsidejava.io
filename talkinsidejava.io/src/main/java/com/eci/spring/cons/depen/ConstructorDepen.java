/**
 * 
 */
package com.eci.spring.cons.depen;

import java.util.List;
import java.util.Map;

/**
 * @author nsingh
 *
 */
public class ConstructorDepen {
	
	private int id;
	private Question question;
	private List<User> users;
	private Map<Question, List<Answers>> quesAnsMap;
	@Override
	public String toString() {
		return "ConstructorDepen [id=" + id + ", question=" + question
				+ ", users=" + users + ", quesAnsMap=" + quesAnsMap + "]";
	}
	public ConstructorDepen(int id, Question question, List<User> users,
			Map<Question, List<Answers>> quesAnsMap) {
		super();
		this.id = id;
		this.question = question;
		this.users = users;
		this.quesAnsMap = quesAnsMap;
	}
	
	

}
