package com.example.demo.game.service;

import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameSession;
import com.example.demo.game.repository.GameRepository;
import com.example.demo.player.entity.PlayerThreeDice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService{
    final private GameRepository gameRepository;

    @Override
    public Game createSimpleGame() {

        // 해당 gameRepository라는 변수를 읽으려면
        // Spring boot에 RequiredArgsConstructor를 달아줘야 정상적으로 인식.
        return gameRepository.createGame();
    }

    @Override
    public GameSession createNewSession(Game game, PlayerThreeDice playerResult1, PlayerThreeDice playerResult2){
        return gameRepository.createNewSession(game, playerResult1, playerResult2);
    }
}
