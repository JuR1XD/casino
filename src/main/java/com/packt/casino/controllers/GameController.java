package com.packt.casino.controllers;

import com.packt.casino.Service.Impl.GamesServiceImpl;
import com.packt.casino.domain.Game;
import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Controller
@RequestMapping("/games")
public class GameController extends AbstractController
{

	@Autowired
	@Resource(name = "GamesService")
	private GamesServiceImpl gamesService;

	@Autowired
	private GamesRepository gamesRepository;

	@RequestMapping
	public String list(Model model, Long id, @RequestParam(name = "error", required = false) String error)
	{
		super.populateUser(model);

		List gameList = gamesService.getAllGames();
		Game game = gamesRepository.findGameByGameId(id);

		if (!game.isActivated())
		{
			model.addAttribute("error", error);
			return "games";
		}
		model.addAttribute("games", gameList);
		return "games";
	}

	@RequestMapping("/game?gameId=${id}")
	public String game(Model model, @PathVariable Long gameId)
	{
		return "game";
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
