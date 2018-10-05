/**
 * 
 */
package com.eci.rest;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * @author nsingh
 *
 */
@Path("/helloWorld")
public class MOWFMService {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		return "Hello to Rest World";
	}
	
	//passing the parameter
	
	//path param
	@GET
	@Path("/helloMsg/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@PathParam("name")String name){
		return "Hello: "+name+" to Rest World";
	}
	
	//query param
	@GET
	@Path("/helloMsgValue")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@QueryParam("name")String name, @QueryParam("value")String value){
		return "Hello: "+name+" to Rest World and i my value is: "+  value;
	}
	
	
	//metrix param
	
	@GET
	@Path("/helloMsgMatrix")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessageMatrix(@MatrixParam("name")String name, @MatrixParam("value")String value){
		return "Hello: "+name+" to Rest World matrix and i my value is: "+  value;
	}
	
	//context param - this is for if we have multiple parameters to pass...
	//for this we have to make sure that this will take as query parameter in the url
	@GET
	@Path("/helloMsgContext")
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessageContext(@Context UriInfo info){
		
		String name = info.getQueryParameters().getFirst("name");
		String value = info.getQueryParameters().getFirst("value");
		return "Hello: "+name+" to Rest World context and i my value is: "+  value;
	}
	
	@GET
	@Path("/getEmployee")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployee(){
		Employee emp = new Employee(1,"Nitin", "Developer");
		emp.setDepartment("finance");
		emp.setName("samadar");
		return emp;
	}
	
	@GET
	@Path("/getEmployeeJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeJSON(){
		Employee emp = new Employee(1,"Nitin", "Developer");
		emp.setDepartment("JSON_finance");
		emp.setName("JSON_samadar");
		return emp;
	}
}
