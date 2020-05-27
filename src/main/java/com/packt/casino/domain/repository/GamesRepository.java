package com.packt.casino.domain.repository;

import com.packt.casino.domain.Game;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GamesRepository extends CrudRepository<Game, Long> {

	Game findGameByGameId(Long gameId);
	Game findGameByName(String name);
}