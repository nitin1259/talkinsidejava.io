/**
 * 
 */
package com.eci.spring.setter.depen;

import java.util.List;

/**
 * @author nsingh
 *
 */
public class Question {
	
	private int id;
	private String ques;
	private List<Answer> answerList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", ques=" + ques + ", answerList="
				+ answerList + "]";
	}
	
	

}
