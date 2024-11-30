package com.example.demo.game.repository;

import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameSession;
import com.example.demo.player.entity.PlayerThreeDice;

public interface GameRepository {
    Game createGame();
    GameSession createNewSession(Game game, PlayerThreeDice playerResult1, PlayerThreeDice playerResult2);
}
