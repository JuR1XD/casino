package com.packt.casino.domain.repository;

import com.packt.casino.domain.Game;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface GamesRepository extends CrudRepository<Game, Long> {

	Game findGameByGameId(Long gameId);
	List<Game> findGamesByName(String name);
	List<Game> findGamesByRelease(String release);

	Game findGameByName(String name);
	Game findGameByRelease(String release);
}