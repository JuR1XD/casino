package com.packt.casino.controllers;


import com.packt.casino.Service.Impl.GamesServiceImpl;
import com.packt.casino.Service.Impl.UserServiceImpl;
import com.packt.casino.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/user")
public class UserController
{

	@Resource(name = "UserService")
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	@Resource(name = "GamesService")
	private GamesServiceImpl gamesService;

	@RequestMapping(path = "/addUser") // Map ONLY POST Requests
	public @ResponseBody
	String addNewUser(User user, @RequestParam String name, @RequestParam String surname,  @RequestParam String email,  @RequestParam String birthday, @RequestParam String street,  @RequestParam String streetNr,
			@RequestParam String postalCode,  @RequestParam String city, @RequestParam String password)
	{
		// @ means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		userService.add(name, surname, email, birthday, password, street, streetNr, postalCode, city);
		//addressService.add(street,streetNr,postalCode,city);
		return "Saved";
	}

	@GetMapping(path = "/getAllUsers")
	public
	String getAllUsers(Model model)
	{
		model.addAttribute("findAllUsers", userService.findAll());
		return "seeAllUsers";
	}

	@RequestMapping(path = "/getEverything")
	public String getAll(@RequestParam Long userId, Model model, @RequestParam Long gameId)
	{
		model.addAttribute("findAllGames", gamesService.findAll());
		model.addAttribute("findAllUsers", userService.findAll());
		model.addAttribute("findUserById", userService.findById(userId));
		model.addAttribute("findGameById", gamesService.findById(gameId));
		return "seeAll";
	}

	@RequestMapping(path = "/deleteUser")
	public @ResponseBody String deleteUser(Long userId)
	{
		userService.remove(userId);
		return "deleted";
	}

	@RequestMapping(path = "/updateUser")
	public @ResponseBody String updateUser(@RequestParam Long userId, @RequestParam String name, @RequestParam String surname,  @RequestParam String email,  @RequestParam String birthday,
			@RequestParam boolean isActivated, @RequestParam boolean admin, @RequestParam int credit, @RequestParam String password, @RequestParam String street, @RequestParam String streetNr, @RequestParam String postalCode, @RequestParam String city)
	{
		userService.update(userId,name,surname, email, birthday, credit, admin, isActivated, password, street, streetNr, postalCode, city);
		return "updated";
	}

	@RequestMapping(path = "/findUserById")
	public  String findUserById(Long userId, Model model)
	{
		model.addAttribute("findUserById", userService.findById(userId));
		return "findUser";
	}

}
