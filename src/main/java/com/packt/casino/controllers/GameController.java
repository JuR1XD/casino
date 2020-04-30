package com.packt.casino.controllers;

import com.packt.casino.Service.Impl.GamesServiceImpl;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.Game;
import com.packt.casino.domain.User;
import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	private UserService userService;

	@RequestMapping
	public String list(Model model, Long id)
	{
		super.populateUser(model);

		List gameList = gamesService.getAllGames();
		model.addAttribute("games", gameList);
		return "games";
	}
	@RequestMapping(value = "/game/{id}")
	public ModelAndView game(Model model, @PathVariable Long id)
	{
		super.populateUser(model);

		ModelAndView mav = new ModelAndView("game");

		Game game = gamesRepository.findGameByGameId(id);
		mav.addObject("isActivated", game.isActivated());
		mav.addObject("game", game);
		mav.addObject("error", !game.isActivated());

		if(game.isActivated())
		{
			mav.addObject("isActivatedText", "Das Spiel ist Aktiviert!");
			return mav;
		}
		else
		{
			mav.addObject("isActivatedText", "Das Spiel ist nicht aktiviert!");
			return mav;
		}
	}

	/*@RequestMapping(value = "/game/{id}/play", method = RequestMethod.GET)
	public ModelAndView play(@PathVariable Long id, @PathVariable String name)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView mav = new ModelAndView();
		Game game = gamesRepository.findGameByGameId(id);
		mav.addObject("game", game);

		if(user.getCredit() <= gamesRepository.findGameByGameId(id).getMin())
		{
			mav.addObject("");
		}

		return mav;
	}*/

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
