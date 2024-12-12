package com.example.demo.player.entity;

import com.example.demo.dice.entity.Dice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickname;

    @Transient
    private List<Dice> diceList = new ArrayList<>();

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public Player() {

    }

    public void updateDice(List<Dice> diceList) {
        this.diceList.clear();
        this.diceList.addAll(diceList);
    }
}
