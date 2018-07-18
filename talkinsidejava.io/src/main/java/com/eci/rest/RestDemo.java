/**
 * 
 */
package com.eci.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author nsingh
 *
 */
@Path("/RestDemo")
public class RestDemo {
	
	@GET
	@Path("/getName")
	@Produces(MediaType.TEXT_PLAIN)
	public String getName(){
		
		return "Ananata";
	}

}
