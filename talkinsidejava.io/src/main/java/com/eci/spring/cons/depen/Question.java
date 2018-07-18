package com.eci.spring.cons.depen;

public class Question {
	private int id;
	private String ques;
	
	public Question(){
		
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", ques=" + ques + "]";
	}
	public Question(int id) {
		super();
		this.id = id;
	}
	public Question(String ques) {
		super();
		this.ques = ques;
	}
	public Question(int id, String ques) {
		super();
		this.id = id;
		this.ques = ques;
	}
	
	
}
