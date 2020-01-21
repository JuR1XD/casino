package com.packt.casino.Service.Impl;

import com.packt.casino.Service.GamesService;
import com.packt.casino.domain.Game;
import com.packt.casino.domain.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("GamesService")
public class GamesServiceImpl implements GamesService
{
	@Autowired
	private GamesRepository gamesRepository;


	@Override
	public void add(Long gameId, String name, double min, String description, boolean isActivated)
	{
		Game game = new Game();

		game.setGameId(gameId);
		game.setName(name);
		game.setMin(min);
		game.setDescription(description);
		game.setActivated(isActivated);
		gamesRepository.save(game);
	}

	@Override
	public void remove(Long gameId)
	{
		gamesRepository.deleteById(gameId);
	}

	@Override
	public void update(Long gameId, String name, double min, String description, boolean isActivated)
	{
		Game game = new Game();

		game.setGameId(16L);
		game.setName("Roulette");
		game.setMin(15.00);
		game.setDescription("Dies ist eine TestBezeichnung");
		game.setActivated(false);
		gamesRepository.save(game);
	}

	@Override
	public Optional<Game> findById(Long gameId)
	{
		return gamesRepository.findById(gameId);
	}

	@Override
	public Iterable<Game> findAll()
	{
		return gamesRepository.findAll();
	}
}
