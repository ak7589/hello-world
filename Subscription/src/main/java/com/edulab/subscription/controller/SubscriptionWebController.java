package com.edulab.subscription.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edulab.subscription.security.login.CognitoAuthService;

@Controller
public class SubscriptionWebController {

	Logger logger = LoggerFactory.getLogger(SubscriptionWebController.class);

	@Autowired
	public CognitoAuthService cognitoAuthService;

	@GetMapping("/")
	public String index_load(Model model) {
		return "redirect:" + cognitoAuthService.getAuthorizationCodeURL();
	}

	@GetMapping("/login")
	String redirectlogin() {

		return "redirect:" + cognitoAuthService.getAuthorizationCodeURL();
	}

	@GetMapping("/login2/oauth2/code/sgep-accounts")
	ModelAndView loginSuccess(@RequestParam Map<String, String> allParams) {

		logger.info("@@@ Map "+allParams);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("data", cognitoAuthService.getToken(allParams.get("code"), allParams.get("state")));
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@GetMapping("/welcome")
	public ModelAndView greeting(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}