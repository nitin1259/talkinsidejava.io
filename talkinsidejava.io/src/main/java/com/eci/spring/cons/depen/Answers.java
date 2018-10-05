package com.eci.spring.cons.depen;

import java.util.List;

public class Answers {

	private int id;
	private List<String> ansList;
	public Answers(int id, List<String> ansList) {
		super();
		this.id = id;
		this.ansList = ansList;
	}
	@Override
	public String toString() {
		return "Answers [id=" + id + ", ansList=" + ansList + "]";
	}
	
	
}
