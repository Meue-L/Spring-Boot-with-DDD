package com.example.demo.player.controller;

import com.example.demo.player.entity.Player;
import com.example.demo.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/player")
public class PlayerController {
    final private PlayerService playerService;

    @GetMapping("/create-player")
    public Player createPlayer() {
        log.info("createPlayer() called!");

        return playerService.createPlayer();
    }

    @GetMapping("/create")
    public Player create(@RequestParam String name) {
        log.info("create("+name+ ") called!");
        if (name!=null) {
            Player createdPlayer = playerService.create(name);
            return createdPlayer;
        } else {
            return null;
        }
    }
}
