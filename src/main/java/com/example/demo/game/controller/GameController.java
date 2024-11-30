package com.example.demo.game.controller;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.service.DiceService;
import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameSession;
import com.example.demo.game.service.GameService;
import com.example.demo.player.entity.Player;
import com.example.demo.player.entity.PlayerThreeDice;
import com.example.demo.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    final private GameService gameService;
    final private PlayerService playerService;
    final private DiceService diceService;

    @GetMapping("/create-simple-game")
    public Game createSimpleGame(){
        log.info("createSimpleGame() called!");

        return gameService.createSimpleGame();
    }

    @GetMapping("/three-dice-roll-game")
    public GameSession threeDiceRollGame(@RequestParam String player1, @RequestParam String player2) {
        log.info("threeDiceRollGame() called!");

        // 게임 생성
        Game newGame = gameService.createSimpleGame();

        // 플레이어 생성 및 주사위 굴리기.
        Player playerA = playerService.create(player1);
        List<Dice> diceListA = diceService.rollThreeDice();

        Player playerB = playerService.create(player2);
        List<Dice> diceListB = diceService.rollThreeDice();

        // 각 플레이어의 결과 임시 저장 (해당 내용 repository에 따로 넣어야 할거같은데.)
        PlayerThreeDice playerResultA = new PlayerThreeDice(playerA, diceListA);
        PlayerThreeDice playerResultB = new PlayerThreeDice(playerB, diceListB);

        // 전체 게임 세션 저장 및 출력
        GameSession newSession = gameService.createNewSession(newGame, playerResultA, playerResultB);

        // 리스트로 출력되야될 해당 세션의 diceList가 diceSum으로 출력되는 문제가 잇음.
        // 왜인지 모르겠음.
        return newSession;
    }
}
