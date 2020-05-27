package com.packt.casino.Service;

import com.packt.casino.domain.factories.GamblingGame;
import com.packt.casino.domain.playVariables.PlayVariables;
import com.packt.casino.domain.playVariables.PlayVariablesRoulette;
import com.packt.casino.domain.playVariables.PlayVariablesRouletteTest;


public interface GamePlayingService
{
	GamblingGame playGame(PlayVariables playVariables, Long gameId);
	GamblingGame playTestGame(Long gameId);
	GamblingGame playTestGameRoulette(Long gameId, PlayVariablesRouletteTest test);
	GamblingGame playGameRoulette(PlayVariablesRoulette playVariables, Long gameId);
	public boolean isWin();
}
