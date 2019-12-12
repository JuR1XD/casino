package com.packt.casino.domain.repository;

import com.packt.casino.domain.Game;

import java.util.ArrayList;
import java.util.List;


public interface GamesRepository
{

	List <Game> games();

	Game getGameById(String gameId);

}
