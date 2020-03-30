package com.packt.casino.Service;

import com.packt.casino.domain.Game;

import java.util.List;
import java.util.Optional;


public interface GamesService
{
	void add(Long gameId, String name, double min, String description, boolean isActivated);
	void remove(Long gameId);
	void update(Long gameId, String name, double min, String description, boolean isActivated);
	Optional<Game> findById(Long gameId);
	Iterable<Game> findAll();
	public List getAllGames();
}
