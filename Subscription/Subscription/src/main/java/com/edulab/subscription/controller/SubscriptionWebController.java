package com.edulab.subscription.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SubscriptionWebController {

	Logger logger = LoggerFactory.getLogger(SubscriptionWebController.class);
 
 
	@GetMapping("/")
	public String index_load (Model model) {
	        return "index";
	}
	
	@GetMapping("/welcome")
	public ModelAndView greeting (Model model) {
		  ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("index");
	        return modelAndView;
	}
}
