package com.packt.casino.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class SearchController
{
	@RequestMapping("/search")
	public String list(Model model)
	{
		return "search";
	}

}
