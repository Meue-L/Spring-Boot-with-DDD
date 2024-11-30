package com.example.demo.game.service;

import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameSession;
import com.example.demo.player.entity.PlayerThreeDice;

public interface GameService {
    Game createSimpleGame();
    GameSession createNewSession(Game game, PlayerThreeDice playerResult1, PlayerThreeDice playerResult2);
}
