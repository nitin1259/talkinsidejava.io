/**
 * 
 */
package com.cc.learning.models;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sinni14
 *
 */
public class Saying {

	private long id;
	
	@Length(max=3)
	private String content;

	@JsonProperty
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Saying(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	
	
}
