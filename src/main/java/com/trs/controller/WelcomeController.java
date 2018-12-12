package com.trs.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/")
	public String index(Model model, HttpServletResponse response) {
	    model.addAttribute("name", "simonsfan");
	    return "admin/index";
	}
}
