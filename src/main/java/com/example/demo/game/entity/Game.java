package com.example.demo.game.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private GameState state;

    private int playerCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Game() {}

    public Game(int playerCount, GameState state) {
        this.playerCount = playerCount;
        this.state = state;
    }

    public void setStateFromValue(int value) {
        this.state = GameState.fromValue(value);
    }
}
