package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@RequestMapping(value = "/")
	public String login(ModelMap modelMap) {
		modelMap.put("name", getLoggedInUserName());
		return "welcome";
	}
	
	
	public String getLoggedInUserName() {
		
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	

}
