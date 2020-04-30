package com.packt.casino.domain.factories;

import com.packt.casino.domain.*;
import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GamblingGameFactory
{
	@Autowired
	GamesRepository gamesRepository;

	public GamblingGame getGameById(Long id)
	{

		if(id == 1)
		{
			return new Bandid();
		}
		else if(id == 2)
		{
			return new Roulette();
		}
		{
			return new Blackjack();
		}
	}

	public ModelAndView getFormById(Long id)
	{
		ModelAndView mav = new ModelAndView();

		if(id == 1)
		{
			mav.setViewName("bandit");
		}
		if(id == 2)
		{
			mav.setViewName("roulette");
		}
		if(id == 3)
		{
			mav.setViewName("blackjack");
		}

		return mav;
	}
}
