package com.example.demo.game.repository;

import com.example.demo.game.entity.Game;
import com.example.demo.game.entity.GameSession;
import com.example.demo.player.entity.PlayerThreeDice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepositoryImpl implements GameRepository{
    static List<Game> gameList = new ArrayList<>();

    // static은 변수 선언문.
    // 이거 안해주면 아래 createGame내부에서 정상적으로 사용 불가.
    static int gameCount = 0;

    @Override
    public Game createGame() {
        // 아래 코드처럼 작성하게 되면 계속해서 새로운 객체가 생성되면서
        // newGame이라는 변수 안에 계속 id 가 1인 game이 새로 생성됨.
        // Game newGame = new Game();

        // 생성하고, 이 값을 계속 증가시키며 사용하려면?
        // 그냥 게임 id를 repository에서 계산하도록 변경.
        Game newGame = new Game(++gameCount);
        gameList.add(newGame);

        return newGame;
    }

    @Override
    public GameSession createNewSession(Game game, PlayerThreeDice playerResult1, PlayerThreeDice playerResult2) {
        GameSession newSession = new GameSession(game, playerResult1, playerResult2);
        return newSession;
    }
}
