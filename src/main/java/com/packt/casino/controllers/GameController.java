package com.packt.casino.controllers;

import com.packt.casino.Service.Impl.GamesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
public class GameController extends AbstractController
{

	@Autowired
	@Resource(name = "GamesService")
	private GamesServiceImpl gamesService;

	@RequestMapping("/games")
	public String list(Model model)
	{
		super.populateUser(model);
		//model.addAttribute()
		return "games";
	}

	@RequestMapping(path = "/addGame") // Map ONLY POST Requests
	public @ResponseBody
	String addNewGame(@RequestParam Long gameId, @RequestParam String name, @RequestParam double min,
			@RequestParam String description, @RequestParam boolean isActivated)
	{
		// @ means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		gamesService.add(gameId, name, min, description, isActivated);
		return "Saved";
	}

	@GetMapping(path = "/getAllGames")
	public String getAllGames(Model model)
	{
		// This returns a JSON or XML with the users
		model.addAttribute("findAllGames", gamesService.findAll());
		return "seeAllGames";
	}

	@RequestMapping(path = "/deleteGame")
	public @ResponseBody
	String deleteGame(Long gameId)
	{
		gamesService.remove(gameId);
		return "deleted";
	}

	@RequestMapping(path = "/updateGame")
	public @ResponseBody
	String updateGame(@RequestParam Long gameId, @RequestParam String name, @RequestParam double min,
			@RequestParam String description, @RequestParam boolean isActivated)
	{
		gamesService.update(gameId, name, min, description, isActivated);
		return "updated";
	}

	@RequestMapping(path = "/findGameById")
	public String findGameById(Model model, Long gameId)
	{
		model.addAttribute("findGameById", gamesService.findById(gameId));
		return "findGame";
	}
}
