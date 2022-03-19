
package com.example.demo;

import static org.junit.Assert.assertNotNull; 
import static org.junit.Assert.assertTrue;


import org.junit.Test; 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest; 
import org.springframework.context.ApplicationContext; 
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.calculator.Calculator; 
import com.example.demo.calculator.CalculatorImpl; 
import com.example.demo.controller.CalcController;

@RunWith(SpringRunner.class)

@SpringBootTest public class DemoApplicationTests {

	@Autowired 
	ApplicationContext ac;

	@Test 
	public void contextLoads() { Calculator calculator =
			ac.getBean(Calculator.class); 
	assertTrue(calculator instanceof
					CalculatorImpl);

			CalcController calcController = ac.getBean(CalcController.class);
			assertNotNull(calcController); } }
