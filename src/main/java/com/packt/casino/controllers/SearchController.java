package com.packt.casino.controllers;

import com.packt.casino.Service.SearchService;
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
import java.util.List;


@Controller
@RequestMapping("/search")
public class SearchController extends AbstractController
{

	@Autowired
	GamesRepository gamesRepository;

	@Autowired
	SearchService searchService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView search(Model model, SearchVariables searchVariables)
	{
		ModelAndView mav = new ModelAndView("search");
		mav.addObject(model);
		mav.addObject("searchTerm", new SearchVariables());
		mav.addObject("searchResult", searchService.searchName(searchVariables));
		mav.addObject("searchResultRelease", searchService.searchRelease(searchVariables));
		mav.addObject("decoy", "-");

		return mav;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView search(Model model, @ModelAttribute("searchTerm") @Valid SearchVariables searchVariables
								,BindingResult result)
	{
		List<Game> gamesListName = searchService.searchName(searchVariables);
		List<Game> gamesListRelease = searchService.searchRelease(searchVariables);

		ModelAndView mav = new ModelAndView("search");
		mav.addObject(model);
		mav.addObject("decoy", "-");
		mav.addObject("otherDecoy", "1600-01-01");

		if(result.hasErrors())
		{
			mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			return mav;
		}
		if(!result.hasErrors() && searchVariables.getRelease().equals("1600-01-01"))
		{
			gamesListName.removeIf(game -> !game.isActivated());
			mav.addObject("searchResult", gamesListName);
		}
		if(!result.hasErrors() && searchVariables.getSearchInput().equals("-"))
		{
			gamesListRelease.removeIf(game -> !game.isActivated());
			mav.addObject("searchResultRelease", gamesListRelease);
		}

		return mav;
	}


	/*@RequestMapping(value = "/byName", method = RequestMethod.GET)
	public ModelAndView searchGameByName(Model model, SearchVariables variables)
	{
		ModelAndView mav = new ModelAndView("searchName");
		mav.addObject(model);
		mav.addObject("searchTerm", new SearchVariables());
		mav.addObject("searchResult", searchService.searchName(variables));

		return mav;

	}
	@RequestMapping(value = "/byRelease", method = RequestMethod.GET)
	public ModelAndView searchGameByRelease(Model model, SearchVariablesRelease variables)
	{
		ModelAndView mav = new ModelAndView("searchRelease");
		mav.addObject(model);
		mav.addObject("searchTermRelease", new SearchVariablesRelease());
		mav.addObject("searchResultRelease", searchService.searchRelease(variables));

		return mav;

	}
	@RequestMapping(value = "/byName", method = RequestMethod.POST)
	public ModelAndView searchGameByName(Model model, @ModelAttribute("searchTerm") @Valid SearchVariables searchVariables,
			BindingResult result)
	{
		List<Game> gamesListName = searchService.searchName(searchVariables);

		ModelAndView mav = new ModelAndView("searchName");
		mav.addObject(model);

		if(result.hasErrors() || gamesListName.isEmpty())
		{
			mav = new ModelAndView("searchName");
			mav.addObject("error", "true");
			return mav;
		}
		if(!result.hasErrors())
		{
			if (!gamesRepository.findGameByName(searchVariables.getSearchInput()).isActivated())
			{
				mav = new ModelAndView("searchName");
				mav.addObject("isActivated", "true");
			}
			else
			{
				mav.addObject("mode", 2);
				mav.addObject("searchResult",  gamesListName);
			}
		}



		return mav;

	}

	@RequestMapping(value = "/byRelease", method = RequestMethod.POST)
	public ModelAndView searchGameByRelease(Model model, @ModelAttribute("searchTerm") @Valid SearchVariablesRelease searchVariables,
			BindingResult result)
	{
		List<Game> gamesListRelease = searchService.searchRelease(searchVariables);
		ModelAndView mav = new ModelAndView("searchRelease");
		mav.addObject(model);

		if(result.hasErrors() || gamesListRelease.isEmpty())
		{
			mav = new ModelAndView("searchRelease");
			mav.addObject("error", "true");
			return mav;
		}
		if(!result.hasErrors())
		{
*//*			if (!gamesListRelease.contains())
			{
				mav = new ModelAndView("searchRelease");
				mav.addObject("isActivated", "true");
			}
			else
			{*//*
				mav.addObject("mode", 2);
				mav.addObject("searchResultRelease", gamesListRelease);
			*//*}*//*
		}



		return mav;

	}*/

}
