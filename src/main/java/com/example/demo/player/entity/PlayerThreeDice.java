package com.example.demo.player.entity;

import com.example.demo.dice.entity.Dice;

import java.util.List;

public class PlayerThreeDice {
    private Player player;
    private List<Dice> diceList;

    public PlayerThreeDice(Player player, List<Dice> diceList) {
        this.player=player;
        this.diceList=diceList;
    }

    public int getDiceSum() {
        int sum = 0;
        for (int i=0; i<this.diceList.size(); i++){
            sum += this.diceList.get(i).getValue();
        }

        return sum;
    }

    public String getPlayer() {
        return this.player.getValue();
    }
}
