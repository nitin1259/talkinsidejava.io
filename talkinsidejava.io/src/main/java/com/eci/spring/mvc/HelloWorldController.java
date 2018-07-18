/**
 * 
 */
package com.eci.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author nsingh
 *
 */

@Controller
public class HelloWorldController {

	/*@RequestMapping("/hello")
	public ModelAndView helloWorld(){
		String message = "Welcome to first spring mvc Page";
		return new ModelAndView("homepage", "message", message);
	}*/
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld(HttpServletRequest req, HttpServletResponse res){
		String user = req.getParameter("userName");
		String password = req.getParameter("password");
		
		if(password.equals("admin") && user.equals("admin")){
			String msg = "Correct credential";
			return new ModelAndView("homepage","message",msg);
		}
		else{
			return new ModelAndView("errorpage", "message","Sorry, username or password error");  
		}
		
	}
}
