package com.packt.casino.controllers;

import com.packt.casino.domain.factories.Bandid;
import com.packt.casino.domain.factories.Blackjack;
import com.packt.casino.domain.factories.GamblingGame;
import com.packt.casino.domain.factories.Roulette;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/games/test")
public class PlayingGameTestController
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

	@RequestMapping(value = "/{id}/play",method = RequestMethod.GET)
	public ModelAndView playGameTest(@PathVariable Long id)
	{
		ModelAndView mav = new ModelAndView();

		mav.setViewName(idToViewName.get(id));
		mav.addObject("getNumbers", idToGameNameNew.get(id));

		return mav;

	}
}
