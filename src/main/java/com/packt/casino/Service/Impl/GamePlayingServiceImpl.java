package com.packt.casino.Service.Impl;

import com.packt.casino.Service.GamePlayingService;
import com.packt.casino.domain.*;
import com.packt.casino.domain.factories.GamblingGame;
import com.packt.casino.domain.factories.GamblingGameFactory;
import com.packt.casino.domain.playVariables.PlayVariables;
import com.packt.casino.domain.repository.GamesRepository;
import com.packt.casino.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class GamePlayingServiceImpl implements GamePlayingService
{
	@Autowired
	UserRepository userRepository;

	@Autowired
	GamesRepository gamesRepository;

	@Autowired
	GamblingGameFactory factory;

	@Override
	public GamblingGame playGame(PlayVariables playVariables, Long gameId)
	{

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findUserByEmail(auth.getName());


		GamblingGame gamblingGame = factory.getGameById(gameId);
		Game game = gamesRepository.findGameByGameId(gameId);

		BigDecimal userCredit = BigDecimal.valueOf(user.getCredit());
		BigDecimal stakeCredit = BigDecimal.valueOf(Double.parseDouble(playVariables.getStake()));
		boolean result = gamblingGame.play();

		if (user.getCredit() > game.getMin() && Double.parseDouble(playVariables.getStake()) >= game.getMin())
		{
			user.setCredit(user.getCredit() - Double.parseDouble(playVariables.getStake()));

			if (gamblingGame.play())
			{
				gamblingGame.setStake(Double.parseDouble(playVariables.getStake()));
				playVariables.setMultiplier(gamblingGame.getMultiplier());
				double profit = gamblingGame.calcProfit();
				user.setCredit(user.getCredit() + profit);
			}

		}
		userRepository.save(user);


		return gamblingGame;
	}

	@Override
	public GamblingGame playTestGame(Long gameId)
	{
		GamblingGame gamblingGame = factory.getGameById(gameId);

		gamblingGame.testPlay();

		return gamblingGame;
	}

}
