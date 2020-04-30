package com.packt.casino.Service.Impl;

import com.packt.casino.Service.GamePlayingService;
import com.packt.casino.domain.*;
import com.packt.casino.domain.factories.GamblingGameFactory;
import com.packt.casino.domain.repository.GamesRepository;
import com.packt.casino.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


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


		if (user.getCredit() > game.getMin() && playVariables.getStake() >= game.getMin())
		{
			user.setCredit(user.getCredit() - playVariables.getStake());
			boolean result = gamblingGame.play();
			if(result)
			{
				gamblingGame.setStake(playVariables.getStake());
				playVariables.setMultiplier(gamblingGame.getMultiplier());
				gamblingGame.setMultiplier(playVariables.getMultiplier());
				double profit = gamblingGame.calcProfit();
				user.setCredit(user.getCredit() + profit);
			}

		}
		userRepository.save(user);

		return gamblingGame;
	}


}
