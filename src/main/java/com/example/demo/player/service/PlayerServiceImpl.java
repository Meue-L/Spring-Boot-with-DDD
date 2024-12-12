package com.example.demo.player.service;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.repository.DiceRepository;
import com.example.demo.player.entity.Player;
import com.example.demo.player.repository.PlayerRepository;
import com.example.demo.player.service.request.PlayerCreateRequest;
import com.example.demo.player.service.request.PlayerFindRequest;
import com.example.demo.player.service.response.PlayerCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;


    @Override
    public PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest) {
        Player player = playerCreateRequest.toPlayer();
        Player createdPlayer = playerRepository.save(player);

        return PlayerCreateResponse.from(createdPlayer);
    }

    @Override
    public Player findPlayer(PlayerFindRequest playerFindRequest) {
        Optional<Player> maybePlayer = playerRepository.findById(playerFindRequest.getPlayerId());
        if (maybePlayer.isEmpty()) {
            log.info("해당 playerId로 찾는 player가 없습니다");
            return null;
        }

        return maybePlayer.get();
    }

    @Override
    public List<Player> listPlayer() {
        List<Player> playerList = playerRepository.findAll();

        return playerList;
    }

    @Override
    public Player findById(Long id) {
        Optional<Player> maybePlayer = playerRepository.findById(id);

        return maybePlayer.get();
    }

    @Override
    public Player updateDiceList(Player player, List<Dice> diceList) {
        // 해당 필드는 현재 @Transient를 통해서 DB에 직접적으로 연동되어 관리 되고 있지 않음
        // player.updateDice(diceList);
        // Player updatedPlayer = playerRepository.save(player);


        // 메모리 단에서 관리하도록 수정.
        player.getDiceList().clear();
        player.getDiceList().addAll(diceList);

        return player;
    }

}
