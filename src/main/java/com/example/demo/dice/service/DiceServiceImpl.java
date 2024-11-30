package com.example.demo.dice.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.repository.DiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService{
    final private DiceRepository diceRepository;

    @Override
    public Dice rollDice() {
        return diceRepository.rollDice();
    }

    @Override
    public List<Dice> rollThreeDice() {
        List<Dice> diceList= new ArrayList<>();

        for (int i = 0; i<3; i++){
            diceList.add(diceRepository.rollDice());
        }

        return diceList;
    }
}
