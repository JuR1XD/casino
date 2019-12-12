package com.packt.casino.domain.repository.impl;

import com.packt.casino.domain.Game;
import com.packt.casino.domain.repository.GamesRepository;

import java.util.ArrayList;
import java.util.List;


public class InMemoryGamesRepository implements GamesRepository
{

	private List<Game> listOfGames = new ArrayList<>();


	public InMemoryGamesRepository()
	{
		Game bandit = new Game("G1", "Einarmiger Bandit", 0.5);
		bandit.setActivated(true);
		bandit.setDescription("Keine Beschreibung bis jetzt");

		Game roulette = new Game("G2", "Roulette", 2.5);
		roulette.setActivated(true);
		roulette.setDescription("Keine Beschreibung bis jetzt");

		Game blackjack = new Game("G3", "Black Jack", 10);
		blackjack.setActivated(true);
		blackjack.setDescription("Keine Beschreibung bis jetzt");

		listOfGames.add(bandit);
		listOfGames.add(roulette);
		listOfGames.add(blackjack);
	}

	@Override
	public List<Game> games()
	{
		return listOfGames;
	}

	@Override
	public Game getGameById(String gameId)
	{
		Game gameByName = null;

		for(Game game : listOfGames)
		{
			if(game != null && game.getName() != null && game.getName().equals(game))
			{
				gameByName = game;

			}
		}
		return null;
	}
}
