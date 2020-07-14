package com.packt.casino.Service;

import com.packt.casino.domain.Game;
import com.packt.casino.domain.search.SearchVariables;

import java.util.List;


public interface SearchService
{
	List<Game> searchName(SearchVariables variables);
	List<Game> searchRelease(SearchVariables variables);
	List<Game> searchReleaseBefore(SearchVariables variables);
	List<Game> searchReleaseAfter(SearchVariables variables);
	List<Game> searchReleaseAfterAndNow(SearchVariables variables);
	List<Game> searchReleaseBeforeAndNow(SearchVariables variables);
	List<Game> searchReleaseBetween(SearchVariables variables);
}
