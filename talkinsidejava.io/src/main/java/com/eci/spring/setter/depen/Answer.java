/**
 * 
 */
package com.eci.spring.setter.depen;

import java.util.List;

/**
 * @author nsingh
 *
 */
public class Answer {
	
	private int id;
	
	private List<String> ansList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<String> getAnsList() {
		return ansList;
	}

	public void setAnsList(List<String> ansList) {
		this.ansList = ansList;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", ansList=" + ansList + "]";
	}
	
	

}
