package com.packt.casino.controllers;


import com.packt.casino.Service.GamesService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
@RequestMapping("/userTest")
public class UserController extends AbstractController
{

	@Resource(name = "UserService")
	@Autowired
	private UserService userService;

	@Autowired
	@Resource(name = "GamesService")
	private GamesService gamesService;

	@RequestMapping(path = "/addUser", method = RequestMethod.GET) // Map ONLY POST Requests
	public String addNewUser(User user, @RequestParam String name, @RequestParam String surname,
			@RequestParam String email, @RequestParam String birthday, @RequestParam String street,
			@RequestParam String streetNr, @RequestParam String postalCode, @RequestParam String city,
			@RequestParam String password)
	{
		// @ means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		userService.add(name, surname, email, birthday, password, street, streetNr, postalCode, city);
		//addressService.add(street,streetNr,postalCode,city);
		return "successfulSignIn";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addNewUserForm(@ModelAttribute("newUser") User newUser)
	{


		return "";
	}

	@GetMapping(path = "/getAllUsers")
	public String getAllUsers(Model model)
	{
		model.addAttribute("findAllUsers", userService.getAllUsers());
		return "seeAllUsers";
	}

	@RequestMapping(path = "/getEverything")
	public String getAll(@RequestParam Long userId, Model model, @RequestParam Long gameId)
	{
		model.addAttribute("findAllGames", gamesService.findAll());
		model.addAttribute("findAllUsers", userService.getAllUsers());
		model.addAttribute("findUserById", userService.findById(userId));
		model.addAttribute("findGameById", gamesService.findById(gameId));
		return "seeAll";
	}

	@RequestMapping(path = "/deleteUser")
	public @ResponseBody
	String deleteUser(Long userId)
	{
		userService.remove(userId);
		return "deleted";
	}

	@RequestMapping(path = "/updateUser")
	public @ResponseBody
	String updateUser(@RequestParam Long userId, @RequestParam String name, @RequestParam String surname,
			@RequestParam String email, @RequestParam String birthday, @RequestParam boolean isActivated,
			@RequestParam boolean admin, @RequestParam int credit, @RequestParam String password,
			@RequestParam String street, @RequestParam String streetNr, @RequestParam String postalCode,
			@RequestParam String city)
	{
		userService
				.update(userId, name, surname, email, birthday, credit, admin, isActivated, password, street,
						streetNr, postalCode, city);
		return "updated";
	}

	@RequestMapping(path = "/findUserById")
	public String findUserById(Long userId, Model model)
	{
		model.addAttribute("findUserById", userService.findById(userId));
		return "findUser";
	}

}
