/**
 * 
 */
package com.eci.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.media.jfxmedia.Media;

/**
 * @author nsingh
 *
 */
@Path("/employee")
public class EmployeeResource {
	
	private EmployeeService empSer = new EmployeeService();
	
	@POST
	@Path("/save")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee save(Employee emp){
		return empSer.save(emp);
	}
	
	@POST
	@Path("/update")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	public Employee update(Employee emp){
		return empSer.update(emp);
	}
	
	@DELETE
	@Path("/deleteEmp/{id}")
	public void delete(@PathParam("id")int empId){
		empSer.delete(empId);
	}
	
	@GET
	@Path("/getEmployeebyId/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee getEmployeebyId(@PathParam("id") int empId){
		return empSer.getEmployeebyId(empId);
	}

	@GET
	@Path("getEmployeeByName/{name}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee getEmployeebyName(@PathParam("name") String empName){
		return empSer.getEmployeebyName(empName);
	}
	
	@GET
	@Path("/getAllEmployees")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Employee> getEmployees(){
		return empSer.getEmployees();
	}

}
