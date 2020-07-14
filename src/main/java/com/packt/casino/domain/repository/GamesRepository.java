package com.packt.casino.domain.repository;

import com.packt.casino.domain.Game;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface GamesRepository extends CrudRepository<Game, Long> {

	Game findGameByGameId(Long gameId);
	List<Game> findGamesByName(String name);
	@Query("select 'release' from Game where release like :release")
	List<Game> findGamesByReleaseContaining(@Param("release") String release);

	List<Game> findGamesByReleaseAfter(String date);

	List<Game> findGamesByReleaseBefore(String date);

	List<Game> findGamesByReleaseAfterOrRelease(String date, String date1);
	List<Game> findGamesByReleaseBeforeOrRelease(String date, String date1);

	List<Game> findGamesByReleaseIsBetween(String firstDate, String secondDate);

	List<Game> findGamesByRelease(String release);

	Game findGameByName(String name);
	Game findGameByRelease(String release);
}
