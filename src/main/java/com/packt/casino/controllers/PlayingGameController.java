package com.packt.casino.controllers;

import com.packt.casino.Service.GamePlayingService;
import com.packt.casino.Service.UserService;
import com.packt.casino.domain.*;
import com.packt.casino.domain.factories.GamblingGameFactory;
import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.net.Authenticator;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/games")
public class PlayingGameController extends AbstractController
{
	private static final Map<Long, String> idToViewName = new HashMap<>();

	static
	{
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

	GamblingGameFactory factory;

	@RequestMapping(value = "/game/{id}/play", method = RequestMethod.GET)
	public ModelAndView playGame(@PathVariable Long id, WebRequest request, Model model)
	{
		populateUser(model);
		Game game = gamesRepository.findGameByGameId(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		ModelAndView mav = new ModelAndView();
		if(user.getCredit() <game.getMin())
		{
			mav.addObject("noCredit", "true");
		}
		if (id == 1)
		{
			mav.setViewName("bandit");
			mav.addObject("min", game.getMin());
			mav.addObject("gameVariables", new PlayVariables());
			mav.addObject("getNumbers", new Bandid());
			mav.addObject("currentMoney", user.getCredit());
		}
		if (id == 2)
		{
			mav.setViewName("roulette");
			mav.addObject("min", game.getMin());
			mav.addObject("gameVariables", new PlayVariables());
			mav.addObject("getNumbers", new Roulette());
		}
		if (id == 3)
		{
			mav.setViewName("blackjack");
			mav.addObject("min", game.getMin());
			mav.addObject("gameVariables", new PlayVariables());
			mav.addObject("getNumbers", new Blackjack());
		}
		/*return new ModelAndView(String.valueOf(factory.getFormById(id)));*/
		/*mav.setViewName(idToViewName.get(id));
		mav.addObject("min", game.getMin());
		mav.addObject("gameVariables", new PlayVariables());
		mav.addObject("getNumbers", factory.getGameById(id));*/


		return mav;
	}

	@RequestMapping(value = "/game/{id}/play", method = RequestMethod.POST)
	public ModelAndView playGamePost(@PathVariable Long id,
			@ModelAttribute("gameVariables") @Valid PlayVariables playVariables, BindingResult result, Model model)
	{
		populateUser(model);

		Game game = gamesRepository.findGameByGameId(id);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());

		ModelAndView mav = new ModelAndView(idToViewName.get(id), "gameVariables", playVariables);
		mav.addObject("currentMoney", user.getCredit());
		if(game.getMin() > user.getCredit())
		{
			mav.addObject("noCredit", "true");
		}
		if (!result.hasErrors())
		{
				mav.addObject("getNumbers", checkForGameErrors(playVariables, result, id));
		}
		if (result.hasErrors())
		{
			return new ModelAndView(idToViewName.get(id), "gameVariables", playVariables);
		}
		return mav;

	}

	private GamblingGame checkForGameErrors(PlayVariables playVariables, BindingResult result, Long id)
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
	}
}
