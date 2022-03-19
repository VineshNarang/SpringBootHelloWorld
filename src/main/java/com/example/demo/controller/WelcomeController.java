package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
	

	
	
	@RequestMapping(value = "/calculatepage", method = RequestMethod.GET)
	public String result1() {
	    	return "calculated";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		//model.put("name", getLoggedinUserName());
		return "welcome";
	}
	

}