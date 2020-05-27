package com.packt.casino.controllers;

import com.packt.casino.domain.Game;
import com.packt.casino.domain.repository.GamesRepository;
import com.packt.casino.domain.search.SearchVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;


@Controller

public class SearchController extends AbstractController
{

	@Autowired
	GamesRepository gamesRepository;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(Model model)
	{
		ModelAndView mav = new ModelAndView("search");
		mav.addObject(model);
		mav.addObject("searchTerm", new SearchVariables());
		//mav.addObject("searchResult", gamesRepository.findGameByName(""));

		return mav;

	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchGame(Model model, @ModelAttribute("searchTerm") @Valid SearchVariables searchVariables,
			BindingResult result)
	{
		ModelAndView mav = new ModelAndView("search");
		mav.addObject(model);
		if(result.hasErrors())
		{
			mav.addObject("error", "true");
		}
		if(!result.hasErrors())
		{
			mav.addObject("searchTerm", searchVariables);
			mav.addObject("searchResult", gamesRepository.findGameByName(searchVariables.getSearchInput()));
		}
		return mav;

	}

}
