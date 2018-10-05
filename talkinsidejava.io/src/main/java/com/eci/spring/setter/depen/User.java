/**
 * 
 */
package com.eci.spring.setter.depen;

import java.util.List;
import java.util.Map;

/**
 * @author nsingh
 *
 */
public class User {
	
	private int id;
	private String name;
	private List<Question> questionList;
	private Map<Question, List<Answer>> userAnswerList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	public Map<Question, List<Answer>> getUserAnswerList() {
		return userAnswerList;
	}
	public void setUserAnswerList(Map<Question, List<Answer>> userAnswerList) {
		this.userAnswerList = userAnswerList;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", questionList="
				+ questionList + ", userAnswerList=" + userAnswerList + "]";
	}
	
	

}
