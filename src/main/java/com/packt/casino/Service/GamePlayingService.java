package com.packt.casino.Service;

import com.packt.casino.domain.Bandid;
import com.packt.casino.domain.GamblingGame;
import com.packt.casino.domain.PlayVariables;
import com.packt.casino.domain.User;


public interface GamePlayingService
{
	GamblingGame playGame(PlayVariables playVariables, Long gameId);
}
