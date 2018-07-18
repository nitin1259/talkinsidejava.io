/**
 * 
 */
package com.eci.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nsingh
 *
 */

@Controller
public class WelcomeWorldController {

	@RequestMapping("/welcome")
	public ModelAndView welcomeMessage(){
		String welcomMsg = "Welcome to Spring welcome Page";
		return new ModelAndView("welcomepage", "welcomeMsg", welcomMsg);
	}
}
