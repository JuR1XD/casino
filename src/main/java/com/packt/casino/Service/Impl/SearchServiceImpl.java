package com.packt.casino.Service.Impl;

import com.packt.casino.Service.SearchService;
import com.packt.casino.domain.Game;
import com.packt.casino.domain.repository.GamesRepository;
import com.packt.casino.domain.search.SearchVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServiceImpl implements SearchService
{

	@Autowired
	GamesRepository gamesRepository;

	@Override
	public List<Game> searchName(SearchVariables variables)
	{
		return gamesRepository.findGamesByName(variables.getSearchInput());
	}

	@Override
	public List<Game> searchRelease(SearchVariables variables)
	{
		return gamesRepository.findGamesByRelease(variables.getRelease());
	}
}
