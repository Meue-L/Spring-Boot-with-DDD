package com.example.demo.dice.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.player.entity.Player;

import java.util.List;

public interface DiceService {
    Dice rollDice();
    Dice PlayerRollDice(Player id);
}
