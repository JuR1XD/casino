package com.packt.casino.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController extends AbstractController
{
	@RequestMapping("/")
	public String welcome(Model model)
	{
		super.populateUser(model);
		model.addAttribute("greeting", "Willkommen zu diesem Online Kasino");
		model.addAttribute("tagline", "Das einzigartige Casino mit drei spielen. So einfach haben sie noch nie gewonnen");

		return "welcome";
	}
}
