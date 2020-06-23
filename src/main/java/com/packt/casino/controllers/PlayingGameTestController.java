package com.packt.casino.controllers;

import com.packt.casino.Service.GamePlayingService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.Game;
import com.packt.casino.domain.factories.*;
import com.packt.casino.domain.playVariables.PlayVariablesRoulette;
import com.packt.casino.domain.playVariables.PlayVariablesRouletteTest;
import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/test")
public class PlayingGameTestController extends AbstractController
{
	private static final Map<Long, String> idToViewName = new HashMap<>();
	private static final Map<Long, GamblingGame> idToGameNameNew = new HashMap<>();


	static
	{
		idToGameNameNew.put(1L, new Bandid());
		idToGameNameNew.put(2L, new Roulette());
		idToGameNameNew.put(3L, new Blackjack());

		idToViewName.put(1L, "banditTest");
		idToViewName.put(2L, "rouletteTest");
		idToViewName.put(3L, "blackjackTest");

	}

	@Autowired
	GamesRepository gamesRepository;

	@Autowired
	UserService userService;

	@Autowired
	GamePlayingService gamePlayingService;

	@Autowired
	GamblingGameFactory factory;

	@RequestMapping(value = "/{id}/play", method = RequestMethod.GET)
	public ModelAndView playGameTest(@PathVariable Long id, Model model)
	{
		populateUser(model);

		ModelAndView mav = new ModelAndView();
		mav.setViewName(idToViewName.get(id));
		mav.addObject("getNumbers", idToGameNameNew.get(id));

		return mav;

	}

	@RequestMapping(value = "/{id}/play", method = RequestMethod.POST)
	public ModelAndView playGameTestPost(@PathVariable Long id, Model model)
	{
		populateUser(model);

		Game game = gamesRepository.findGameByGameId(id);


		GamblingGame gamblingGame = gamePlayingService.playTestGame(id);

		ModelAndView mav = new ModelAndView(idToViewName.get(id));

		mav.addObject("getNumbers", gamblingGame);
		if (gamePlayingService.isWin())
		{
			mav.addObject("win", "true");
		}

		return mav;
	}

	@RequestMapping(value = "/2/play", method = RequestMethod.GET)
	public ModelAndView playGameRouletteTest(Model model)
	{
		populateUser(model);

		ModelAndView mav = new ModelAndView();
		mav.setViewName(idToViewName.get(2L));
		mav.addObject("getNumbers", idToGameNameNew.get(2L));
		mav.addObject("inputRoulette", new PlayVariablesRouletteTest());

		return mav;

	}

	@RequestMapping(value = "/2/play", method = RequestMethod.POST)
	public ModelAndView playGameTestRoulettePost(
			@ModelAttribute("inputRoulette") PlayVariablesRouletteTest playVariablesRouletteTest,
			BindingResult result, Model model)
	{
		populateUser(model);

		Game game = gamesRepository.findGameByGameId(2L);

		if (result.hasErrors())
		{
			ModelAndView mav;

			mav = new ModelAndView(idToViewName.get(2L), "inputRoulette",  playVariablesRouletteTest);
			mav.addObject("getNumber", idToGameNameNew.get(2L));

			return mav;
		}
		GamblingGame gamblingGame = null;
		try
		{
			gamblingGame = gamePlayingService.playTestGameRoulette(2L, playVariablesRouletteTest);
		}
		catch (NumberFormatException e)
		{
			ModelAndView mav = new ModelAndView("rouletteTest");
			mav.addObject("numberFormat", "true");
			mav.addObject("getNumbers", idToGameNameNew.get(2L));
			mav.addObject("inputRoulette", new PlayVariablesRouletteTest());
			return mav;
		}


		ModelAndView mav = new ModelAndView();

		if (!result.hasErrors())
		{

			mav = new ModelAndView(idToViewName.get(2L), "inputRoulette", playVariablesRouletteTest);
			mav.addObject("getNumbers", gamblingGame);
			if (gamePlayingService.isWin())
			{
				mav.addObject("win", "true");
			}
		}
		return mav;
	}
}
