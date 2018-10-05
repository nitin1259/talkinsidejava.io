/**
 * 
 */
package com.cc.learning.application;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

/**
 * @author sinni14
 *
 */
public class ApiHandlerConfiguration extends Configuration{

	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName;

	@JsonProperty
	public String getTemplate() {
		return template;
	}

	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}

	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}
	
	
}
