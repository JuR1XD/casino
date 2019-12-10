package com.packt.casino.controllers;

import com.packt.casino.domain.Game;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GameController
{
	@RequestMapping("/games")
	public String list(Model model)
	{
		return "games";
	}
}
