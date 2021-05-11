package com.link.web;

import com.link.web.model.CalculatorForm;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

	@GetMapping("/calculator-result")
	public ModelAndView calculate(@RequestParam(name = "first", required = false) int first, 
			@RequestParam(name = "second") int second) {		
		ModelAndView model = new ModelAndView("calculator.html");
		int result = first + second;
		model.addObject("result", result);
		return model;
	}

	@PostMapping(value="/calculator-result-post", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView calculatePost(CalculatorForm calculatorForm) {
		ModelAndView model = new ModelAndView("calculator.html");
		Integer result = calculatorForm.add();
		model.addObject("result", result);
		return model;
	}
	
	@GetMapping("/calculator")
	public ModelAndView display() {		
		ModelAndView model = new ModelAndView("calculator.html");
		return model;
	}
	
}
