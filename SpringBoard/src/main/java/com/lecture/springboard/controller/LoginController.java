package com.lecture.springboard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model) {
		model.addAttribute("userId", request.getParameter("userId"));
		model.addAttribute("password", request.getParameter("password"));
		return "home";
	}

}
