
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.calculator.Calculator;

@RestController
public class CalcController {
	@Autowired
	public Calculator calculator;

	

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public @ResponseBody String result(@RequestParam("expression")String expression) {
	    	try {
	    		return Double.toString(calculator.process(expression));
	    		
        		//return ;
    		} catch (Exception e) {
        		return e.getMessage();
	    	}
	}
	
	

}
