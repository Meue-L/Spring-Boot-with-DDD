package com.example.demo.dice.controller;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.service.DiceService;

import com.example.demo.player.entity.Player;
import com.example.demo.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// RestController는 기본적으로 다루는 데이터를 전부 JSON으로 처리
// Slf4j는 기본적으로 로그를 작성할 때 활용

@Slf4j
@RequestMapping("/dice")
@RequiredArgsConstructor
@RestController
public class DiceController {
    final private DiceService diceService;
    final private PlayerService playerService;

    @GetMapping("/test")
    public String diceTest() {
        log.info("diceTest() called");

        return "diceTest() called";
    }

    // Spring Framework에서는 json 리턴 타입을 맞추려면 class 타입으로 리턴해야 한다.
    @GetMapping("/roll-dice")
    public Dice rollDice() {
        log.info("rollDice() called");

        Dice acquiredDiceNumber = diceService.rollDice();

        return acquiredDiceNumber;
    }

    @GetMapping("/roll-dice-for-simple-game")
    public Player rollDiceForSimpleGame(@RequestParam Long id) {
        log.info("rollDiceForSimpleGame() called");
        List<Dice> diceList = new ArrayList<>();

        Player foundPlayer = playerService.findById(id);
        for (int i = 0; i < 3; i++) {
            Dice newDice = diceService.PlayerRollDice(foundPlayer);
            diceList.add(newDice);
        }

        Player updatedPlayer = playerService.updateDiceList(foundPlayer, diceList);

        return updatedPlayer;
    }
}
