package com.packt.casino.Service;

import com.packt.casino.domain.factories.GamblingGame;
import com.packt.casino.domain.playVariables.PlayVariables;


public interface GamePlayingService
{
	GamblingGame playGame(PlayVariables playVariables, Long gameId);
	GamblingGame playTestGame(Long gameId);
}
