package com.eci.rest;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
/**
 * 
 */
import com.sun.jersey.api.client.WebResource;

/**
 * @author nsingh
 *
 */
public class MOWFMClient {
	
	public static void main(String [] args){
		Client client = Client.create();
		WebResource webRes = client.resource("http://localhost:8081/RespApiAppDemo/rest/helloWorld/helloMsg/nitin");
		ClientResponse response = webRes.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
		String output = response.getEntity(String.class);
		System.out.println("out: "+output);
		
		callService();
		
		callGetEmployeeService();
	}

	
	public static void callService(){
		Client client  = Client.create();
		WebResource resource = client.resource("http://localhost:8081/RespApiAppDemo/rest/helloWorld/helloMsgContext?name=Sachin&value=24");
		ClientResponse response = resource.accept(MediaType.TEXT_PLAIN).get(ClientResponse.class);
		String outString = response.getEntity(String.class);
		System.out.println("outstring: "+outString);
	}
	
	public static void callGetEmployeeService(){
		Client client  = Client.create();
		WebResource resource = client.resource("http://localhost:8081/RespApiAppDemo/rest/helloWorld/getEmployee");
		ClientResponse response = resource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
		Employee outString = response.getEntity(Employee.class);
		System.out.println("Employee Name: "+outString.getName());
		
		/*String output = response.getEntity(String.class);
		System.out.println("out: "+output);*/
	}
}
