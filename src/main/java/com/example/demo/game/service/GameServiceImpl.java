package com.example.demo.game.service;

import com.example.demo.game.entity.Game;
import com.example.demo.game.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    final private GameRepository gameRepository;

    @Override
    public Game createGame() {
        Game newgame = new Game();
        Game createdGame = gameRepository.save(newgame);
        // save의 경우, 새로운 객체를 생성 후 호출해야 정상적으로 DB에 적용된다.

        return createdGame;
    }
}
