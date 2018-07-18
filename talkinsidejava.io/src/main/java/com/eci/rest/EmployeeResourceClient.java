/**
 * 
 */
package com.eci.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * @author nsingh
 *
 */
public class EmployeeResourceClient {
	
	public static void getEmpById(){
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8081/RespApiAppDemo/rest/employee/getEmployeebyId/2");
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Employee emp = response.getEntity(Employee.class);
		System.out.println("Employee by Id: "+emp);
	}
	
	public static void getEmpByName(){
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8081/RespApiAppDemo/rest/employee/getEmployeeByName/Sachin");
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		Employee emp = response.getEntity(Employee.class);
		System.out.println("Employee by Id: "+emp);
		}
	
	public static void getAllEmp(){
		Client client = Client.create();
		WebResource resource = client.resource("http://localhost:8081/RespApiAppDemo/rest/employee/getAllEmployees");
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		List<Employee> emplist = response.getEntity(new GenericType<List<Employee>>(){});
		System.out.println("Employee list: "+emplist);
	}
	
	public static void main(String [] args){
		getEmpById();
		getEmpByName();
		getAllEmp();
	}

}
