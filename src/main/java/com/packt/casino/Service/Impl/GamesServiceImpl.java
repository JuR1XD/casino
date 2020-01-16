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
	public void add(Game game)
	{
		game.setGameId(16L);
		game.setName("Einarmiger Bandit");
		game.setMin(0);
		game.setDescription("Dies ist eine TestBezeichnung");
		game.setActivated(true);
		gamesRepository.save(game);
	}

	@Override
	public void remove()
	{
		gamesRepository.deleteById(16L);
	}

	@Override
	public void update(Game game)
	{
		game.setGameId(16L);
		game.setName("Roulette");
		game.setMin(15.00);
		game.setDescription("Dies ist eine TestBezeichnung");
		game.setActivated(false);
		gamesRepository.save(game);
	}

	@Override
	public Optional<Game> findById()
	{
		return gamesRepository.findById(18L);
	}

	@Override
	public Iterable<Game> findAll()
	{
		return gamesRepository.findAll();
	}
}
