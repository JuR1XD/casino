package com.packt.casino.Service;

import com.packt.casino.domain.Game;

import java.util.Optional;


public interface GamesService
{
	void add(Game game);
	void remove();
	void update(Game game);
	Optional<Game> findById();
	Iterable<Game> findAll();
}
