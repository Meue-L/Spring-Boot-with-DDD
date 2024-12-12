package com.example.demo.dice.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.repository.DiceRepository;
import com.example.demo.player.entity.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {
    final private DiceRepository diceRepository;

    @Override
    public Dice rollDice() {
        long randomNumber = (long) Math.random() * 6 + 1;
        Dice dice = new Dice(randomNumber);
        Dice createdDice = diceRepository.save(dice);

        return createdDice;
    }

    @Override
    public Dice PlayerRollDice(Player player) {
        Random random = new Random();

        long randomNumber = random.nextInt(6) + 1;
        Dice dice = new Dice(randomNumber);
        Dice createdDice = diceRepository.save(dice);
        createdDice.savePlayerId(player.getId());
        Dice playerSetDice = diceRepository.save(createdDice);

        return playerSetDice;
    }
}
