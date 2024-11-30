package com.example.demo.player.repository;

import com.example.demo.player.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository{

    static List<Player> playerList = new ArrayList<>();

    final String playerNickname = "player0";
    int playerCount = 0;

    @Override
    public Player create() {
        String nickname = playerNickname + ++playerCount;
        Player player = new Player(nickname);

        playerList.add(player);
        return player;
    }

    @Override
    public Player createPlayer(String name) {
        try {
            // 중복 로직 구현하지 않음.
            // 동일 닉네임은 계속해서 생성 가능함.

            Player player = new Player(name);

            playerList.add(player);
            return player;
        } catch (Exception e) {
            return null;
        }
    }
}
