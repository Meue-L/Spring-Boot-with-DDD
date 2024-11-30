package com.example.demo.game.entity;

import lombok.Getter;

@Getter
public class Game {
    private int gameId = 0;

    public Game(int Id) {this.gameId = Id;}
}
