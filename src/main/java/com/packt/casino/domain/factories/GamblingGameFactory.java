package com.packt.casino.domain.factories;

import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GamblingGameFactory
{
	@Autowired
	GamesRepository gamesRepository;

	private Bandid bandid;
	private Roulette roulette;
	private Blackjack blackjack;

	public GamblingGame getGameById(Long id)
	{

		if(id == 1)
		{
			if(bandid == null)
			{
				bandid = new Bandid();
			}
			return bandid;
		}
		else if(id == 2)
		{
			if(roulette == null)
			{
				roulette = new Roulette();
			}
			return roulette;
		}
		else
		{
			if(blackjack == null)
			{
				blackjack = new Blackjack();
			}
			return blackjack;
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
