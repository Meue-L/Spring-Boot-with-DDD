package com.example.demo.game.entity;

import com.example.demo.player.entity.PlayerThreeDice;
import lombok.Getter;

import java.util.List;

@Getter
public class GameSession {
    private Game game;
    private PlayerThreeDice playerResult1;
    private PlayerThreeDice PlayerResult2;
    private String winner;

    public GameSession(Game game, PlayerThreeDice playerResult1, PlayerThreeDice playerResult2)
    {
        this.game = game;
        this.playerResult1=playerResult1;
        this.PlayerResult2=playerResult2;
        if(playerResult1.getDiceSum() == playerResult2.getDiceSum()){
            this.winner = "Draw!";
        } else {
            this.winner = String.format("player %s win!", (playerResult2.getDiceSum() < playerResult1.getDiceSum() ? playerResult1.getPlayer() : playerResult2.getPlayer()));
        }
    }
}
