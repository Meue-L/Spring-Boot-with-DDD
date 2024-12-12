package com.example.demo.player.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.player.entity.Player;
import com.example.demo.player.service.request.PlayerCreateRequest;
import com.example.demo.player.service.request.PlayerFindRequest;
import com.example.demo.player.service.response.PlayerCreateResponse;

import java.util.List;

public interface PlayerService {
    PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest);

    Player findPlayer(PlayerFindRequest playerFindRequest);

    List<Player> listPlayer();

    Player findById(Long id);

    Player updateDiceList(Player player, List<Dice> diceList);
}
