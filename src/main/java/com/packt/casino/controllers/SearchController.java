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
import java.util.ArrayList;
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
		populateUser(model);

		ModelAndView mav = new ModelAndView("search");
		mav.addObject(model);
		mav.addObject("searchTerm", new SearchVariables());
		mav.addObject("searchResult", new ArrayList<>());
		mav.addObject("searchResultRelease", new ArrayList<>());
		mav.addObject("single", "true");

		return mav;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView search(Model model, @ModelAttribute("searchTerm") @Valid SearchVariables searchVariables
								,BindingResult result)
	{
		populateUser(model);

		List<Game> gamesListName = searchService.searchName(searchVariables);
		List<Game> gamesListReleaseSingle = null;
		List<Game> gamesListReleaseAfter = null;
		List<Game> gamesListReleaseBefore = null;
		List<Game> gamesListReleaseAfterAndNow = null;
		List<Game> gamesListReleaseBeforeAndNow = null;
		List<Game> gamesListReleaseBetween = null;
		try
		{
			gamesListReleaseSingle = searchService.searchRelease(searchVariables);
		}
		catch (Exception e)
		{
			ModelAndView mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			mav.addObject("searchResult", new ArrayList<>());
			mav.addObject("searchResultRelease", new ArrayList<>());
			mav.addObject("errorsRelease", "true");
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			return mav;
		}
		try
		{
			gamesListReleaseAfter = searchService.searchReleaseAfter(searchVariables);
		}
		catch (Exception e)
		{
			ModelAndView mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			mav.addObject("searchResult", new ArrayList<>());
			mav.addObject("searchResultRelease", new ArrayList<>());
			mav.addObject("errorsRelease", "true");
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			return mav;
		}
		try
		{
			gamesListReleaseBefore = searchService.searchReleaseBefore(searchVariables);
		}
		catch (Exception e)
		{
			ModelAndView mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			mav.addObject("searchResult", new ArrayList<>());
			mav.addObject("searchResultRelease", new ArrayList<>());
			mav.addObject("errorsRelease", "true");
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			return mav;
		}
		try
		{
			gamesListReleaseAfterAndNow = searchService.searchReleaseAfterAndNow(searchVariables);
		}
		catch (Exception e)
		{
			ModelAndView mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			mav.addObject("searchResult", new ArrayList<>());
			mav.addObject("searchResultRelease", new ArrayList<>());
			mav.addObject("errorsRelease", "true");
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			return mav;
		}
		try
		{
			gamesListReleaseBeforeAndNow = searchService.searchReleaseBeforeAndNow(searchVariables);
		}
		catch (Exception e)
		{
			ModelAndView mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			mav.addObject("searchResult", new ArrayList<>());
			mav.addObject("searchResultRelease", new ArrayList<>());
			mav.addObject("errorsRelease", "true");
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			return mav;
		}
		try
		{
			gamesListReleaseBetween = searchService.searchReleaseBetween(searchVariables);
		}
		catch (Exception e)
		{
			ModelAndView mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			mav.addObject("searchResult", new ArrayList<>());
			mav.addObject("searchResultRelease", new ArrayList<>());
			mav.addObject("errorsRelease", "true");
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			mav.addObject("before", "true");
			mav.addObject("after", "false");
			mav.addObject("single", "false");
			mav.addObject("beforeNow", "false");
			mav.addObject("afterNow", "false");
			mav.addObject("between", "true");
			return mav;
		}



		ModelAndView mav = new ModelAndView("search");
		mav.addObject(model);
		mav.addObject("decoy", "-");
		mav.addObject("otherDecoy", "1600-01-01");

		if(result.hasErrors() )
		{
			mav = new ModelAndView("search");
			mav.addObject("searchTerm", new SearchVariables());
			mav.addObject("searchResult", new ArrayList<>());
			mav.addObject("searchResultRelease", new ArrayList<>());
			mav.addObject("errorsName", "true");
			return mav;
		}
		if(!result.hasErrors() && searchVariables.getRelease().equals("1600-01-01"))
		{
			gamesListName.removeIf(game -> !game.isActivated());
			mav.addObject("searchResult", gamesListName);
			mav.addObject("name", "true");
			mav.addObject("release", "false");
		}
		if(!result.hasErrors() && searchVariables.getSearchInput().equals("-"))
		{
			gamesListReleaseSingle.removeIf(game -> !game.isActivated());
			mav.addObject("searchResultRelease", gamesListReleaseSingle);
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			mav.addObject("single", "true");
			mav.addObject("beforeNow", "false");
			mav.addObject("afterNow", "false");
			mav.addObject("after", "false");
			mav.addObject("before", "false");
			mav.addObject("between", "false");
		}
		if(!result.hasErrors() && searchVariables.getSearchInput().equals("-."))
		{
			gamesListReleaseAfter.removeIf(game -> !game.isActivated());
			mav.addObject("searchResultRelease", gamesListReleaseAfter);
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			mav.addObject("after", "true");
			mav.addObject("before", "false");
			mav.addObject("single", "false");
			mav.addObject("beforeNow", "false");
			mav.addObject("afterNow", "false");
			mav.addObject("between", "false");
		}
		if(!result.hasErrors() && searchVariables.getSearchInput().equals(".-"))
		{
			gamesListReleaseBefore.removeIf(game -> !game.isActivated());
			mav.addObject("searchResultRelease", gamesListReleaseBefore);
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			mav.addObject("before", "true");
			mav.addObject("after", "false");
			mav.addObject("single", "false");
			mav.addObject("beforeNow", "false");
			mav.addObject("afterNow", "false");
			mav.addObject("between", "false");
		}
		if(!result.hasErrors() && searchVariables.getSearchInput().equals("--"))
		{
			gamesListReleaseAfterAndNow.removeIf(game -> !game.isActivated());
			mav.addObject("searchResultRelease", gamesListReleaseAfterAndNow);
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			mav.addObject("before", "true");
			mav.addObject("after", "false");
			mav.addObject("single", "false");
			mav.addObject("beforeNow", "false");
			mav.addObject("afterNow", "true");
			mav.addObject("between", "false");
		}
		if(!result.hasErrors() && searchVariables.getSearchInput().equals("--."))
		{
			gamesListReleaseBeforeAndNow.removeIf(game -> !game.isActivated());
			mav.addObject("searchResultRelease", gamesListReleaseBeforeAndNow);
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			mav.addObject("before", "true");
			mav.addObject("after", "false");
			mav.addObject("single", "false");
			mav.addObject("beforeNow", "true");
			mav.addObject("afterNow", "false");
			mav.addObject("between", "false");
		}
		if(!result.hasErrors() && searchVariables.getSearchInput().equals("--.-"))
		{
			gamesListReleaseBetween.removeIf(game -> !game.isActivated());
			mav.addObject("searchResultRelease", gamesListReleaseBetween);
			mav.addObject("name", "false");
			mav.addObject("release", "true");
			mav.addObject("before", "true");
			mav.addObject("after", "false");
			mav.addObject("single", "false");
			mav.addObject("beforeNow", "false");
			mav.addObject("afterNow", "false");
			mav.addObject("between", "true");
		}

		return mav;
	}

}
