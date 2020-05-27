package com.packt.casino.controllers;

import com.packt.casino.Service.GamePlayingService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.*;
import com.packt.casino.domain.factories.*;
import com.packt.casino.domain.playVariables.PlayVariablesBandit;
import com.packt.casino.domain.playVariables.PlayVariablesBlackjack;
import com.packt.casino.domain.playVariables.PlayVariablesRoulette;
import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/games/game")
public class PlayingGameController extends AbstractController
{
	private static final Map<Long, String> idToViewName = new HashMap<>();
	private static final Map<Long, GamblingGame> idToGameNameNew = new HashMap<>();


	static
	{
		idToGameNameNew.put(1L, new Bandid());
		idToGameNameNew.put(2L, new Roulette());
		idToGameNameNew.put(3L, new Blackjack());

		idToViewName.put(1L, "bandit");
		idToViewName.put(2L, "roulette");
		idToViewName.put(3L, "blackjack");

	}

	@Autowired
	GamesRepository gamesRepository;

	@Autowired
	UserService userService;

	@Autowired
	GamePlayingService gamePlayingService;
	@Autowired
	GamblingGameFactory factory;

	@RequestMapping(value = "/1/play", method = RequestMethod.GET)
	public ModelAndView playGameBandid(WebRequest request, Model model)
	{
		populateUser(model);
		Game game = gamesRepository.findGameByGameId(1L);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		ModelAndView mav = new ModelAndView();
		if (user.getCredit() < game.getMin())
		{
			mav.addObject("noCredit", "true");
		}
		mav.addObject("currentMoney", user.getCredit());
		mav.addObject("min", game.getMin());
		//mav.addObject(idToGameNameModelAttributeName.get(id), idToGameNamePlayVariables.get(id));
		mav.setViewName("bandit");
		mav.addObject("playVariablesBandit", new PlayVariablesBandit());
		mav.addObject("getNumbers", idToGameNameNew.get(1L));
		/*return new ModelAndView(String.valueOf(factory.getFormById(id)));*/
		/*mav.setViewName(idToViewName.get(id));
		mav.addObject("min", game.getMin());
		mav.addObject("gameVariables", new PlayVariables());
		mav.addObject("getNumbers", factory.getGameById(id));*/


		return mav;
	}

	@RequestMapping(value = "/1/play", method = RequestMethod.POST)
	public ModelAndView playGameBandidPost(
			@ModelAttribute("playVariablesBandit") @Valid PlayVariablesBandit playVariables,
			BindingResult result, Model model)
	{
		populateUser(model);

		Game game = gamesRepository.findGameByGameId(2L);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		if (result.hasErrors() || Double.parseDouble(playVariables.getStake()) > user.getCredit())
		{
			ModelAndView mav;

			mav = new ModelAndView(idToViewName.get(1L), "gameVariablesBandit", playVariables);
			mav.addObject("currentMoney", user.getCredit());
			mav.addObject("getNumbers", idToGameNameNew.get(1L));

			if(Double.parseDouble(playVariables.getStake()) > user.getCredit())
			{
				mav.addObject("toMuchCredit", "true");
			}

			if(game.getMin() > Double.parseDouble(playVariables.getStake()))
			{
				mav.addObject("toLessCredit", "true");
			}
			if (game.getMin() > user.getCredit())
			{
				mav.addObject("noCredit", "true");
			}
			return mav;
		}
		GamblingGame gamblingGame = gamePlayingService.playGame(playVariables, 1L);

		ModelAndView mav = new ModelAndView();
		mav.addObject("currentMoney", user.getCredit());

		if (!result.hasErrors())
		{
			mav = new ModelAndView(idToViewName.get(1L), "playVariablesBandit", playVariables);
			mav.addObject("currentMoney", user.getCredit());
			mav.addObject("getNumbers", gamblingGame);
		}

		if (game.getMin() > user.getCredit())
		{
			mav.addObject("noCredit", "true");
		}
		if(gamePlayingService.isWin())
		{
			mav.addObject("win", "true");
		}

		return mav;

	}

	@RequestMapping(value = "/2/play", method = RequestMethod.GET)
	public ModelAndView playGameRoulette(WebRequest request, Model model)
	{
		populateUser(model);
		Game game = gamesRepository.findGameByGameId(2L);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		ModelAndView mav = new ModelAndView();
		if (user.getCredit() < game.getMin())
		{
			mav.addObject("noCredit", "true");
		}
		mav.addObject("currentMoney", user.getCredit());
		mav.addObject("min", game.getMin());
		//mav.addObject(idToGameNameModelAttributeName.get(id), idToGameNamePlayVariables.get(id));
		mav.setViewName("roulette");
		mav.addObject("playVariablesRoulette", new PlayVariablesRoulette());
		mav.addObject("getNumber", idToGameNameNew.get(2L));
		/*return new ModelAndView(String.valueOf(factory.getFormById(id)));*/
		/*mav.setViewName(idToViewName.get(id));
		mav.addObject("min", game.getMin());
		mav.addObject("gameVariables", new PlayVariables());
		mav.addObject("getNumbers", factory.getGameById(id));*/


		return mav;
	}

	@RequestMapping(value = "/2/play", method = RequestMethod.POST)
	public ModelAndView playGameRoulettePost(
			@ModelAttribute("playVariablesRoulette") @Valid PlayVariablesRoulette playVariablesRoulette,
			BindingResult result, Model model)
	{
		populateUser(model);

		Game game = gamesRepository.findGameByGameId(2L);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		if (result.hasErrors() || Double.parseDouble(playVariablesRoulette.getStake()) > user.getCredit())
		{
			ModelAndView mav;

			mav = new ModelAndView(idToViewName.get(2L), "gameVariablesRoulette", playVariablesRoulette);
			mav.addObject("currentMoney", user.getCredit());
			mav.addObject("getNumber", idToGameNameNew.get(2L));

			if(Double.parseDouble(playVariablesRoulette.getStake()) > user.getCredit())
			{
				mav.addObject("toMuchCredit", "true");
			}

			if(game.getMin() > Double.parseDouble(playVariablesRoulette.getStake()))
			{
				mav.addObject("toLessCredit", "true");
			}
			if (game.getMin() > user.getCredit())
			{
				mav.addObject("noCredit", "true");
			}
			return mav;
		}
		GamblingGame gamblingGame = gamePlayingService.playGameRoulette(playVariablesRoulette, 2L);

		ModelAndView mav = new ModelAndView();
		mav.addObject("currentMoney", user.getCredit());

		if (!result.hasErrors())
		{
			mav = new ModelAndView(idToViewName.get(2L), "playVariablesRoulette", playVariablesRoulette);
			mav.addObject("currentMoney", user.getCredit());
			mav.addObject("getNumber", gamblingGame);
		}

		if (game.getMin() > user.getCredit())
		{
			mav.addObject("noCredit", "true");
		}
		if(gamePlayingService.isWin())
		{
			mav.addObject("win", "true");
		}
		return mav;

	}

	@RequestMapping(value = "/3/play", method = RequestMethod.GET)
	public ModelAndView playGameBlackjack(WebRequest request, Model model)
	{
		populateUser(model);
		Game game = gamesRepository.findGameByGameId(3L);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		ModelAndView mav = new ModelAndView();
		if (user.getCredit() < game.getMin())
		{
			mav.addObject("noCredit", "true");
		}
		mav.addObject("currentMoney", user.getCredit());
		mav.addObject("min", game.getMin());
		//mav.addObject(idToGameNameModelAttributeName.get(id), idToGameNamePlayVariables.get(id));
		mav.setViewName("blackjack");
		mav.addObject("playVariablesBlackjack", new PlayVariablesBlackjack());
		mav.addObject("getCards", idToGameNameNew.get(3L));
		/*return new ModelAndView(String.valueOf(factory.getFormById(id)));*/
		/*mav.setViewName(idToViewName.get(id));
		mav.addObject("min", game.getMin());
		mav.addObject("gameVariables", new PlayVariables());
		mav.addObject("getNumbers", factory.getGameById(id));*/


		return mav;
	}

	@RequestMapping(value = "/3/play", method = RequestMethod.POST)
	public ModelAndView playGameBlackjackPost(
			@ModelAttribute("playVariablesBlackjack") @Valid PlayVariablesBlackjack playVariablesBlackjack,
			BindingResult result, Model model)
	{
		populateUser(model);

		Game game = gamesRepository.findGameByGameId(3L);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		if (result.hasErrors() || Double.parseDouble(playVariablesBlackjack.getStake()) > user.getCredit())
		{
			ModelAndView mav;

				mav = new ModelAndView(idToViewName.get(3L), "gameVariablesBlackjack",
						playVariablesBlackjack);
				mav.addObject("currentMoney", user.getCredit());
				mav.addObject("getCards", idToGameNameNew.get(3L));

			if(Double.parseDouble(playVariablesBlackjack.getStake()) > user.getCredit())
			{
				mav.addObject("toMuchCredit", "true");
			}

			if(game.getMin() > Double.parseDouble(playVariablesBlackjack.getStake()))
			{
				mav.addObject("toLessCredit", "true");
			}
			if (game.getMin() > user.getCredit())
			{
				mav.addObject("noCredit", "true");
			}
			return mav;
		}
		GamblingGame gamblingGame = gamePlayingService.playGame(playVariablesBlackjack, 3L);

		ModelAndView mav = new ModelAndView();
		mav.addObject("currentMoney", user.getCredit());

		if (!result.hasErrors())
		{

				mav = new ModelAndView(idToViewName.get(3L), "playVariablesBlackjack",
						playVariablesBlackjack);
				mav.addObject("currentMoney", user.getCredit());
				mav.addObject("getCards", gamblingGame);

		}

		if (game.getMin() > user.getCredit())
		{
			mav.addObject("noCredit", "true");
		}
		if(gamePlayingService.isWin())
		{
			mav.addObject("win", "true");
		}

		return mav;

	}

/*	private GamblingGame checkForGameErrors(PlayVariablesBandit playVariables, BindingResult result, Long id)
	{
		GamblingGame registered;

		try
		{
			registered = gamePlayingService.playGame(playVariables, id);
		}
		catch (IllegalStateException e)
		{
			result.rejectValue("getNumbers", "casino.edit.NotNull.credit");
			return null;
		}

		return registered;
	}*/
}
