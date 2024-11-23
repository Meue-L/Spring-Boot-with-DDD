package com.example.demo.dice.entity;

import lombok.Getter;

@Getter
public class Dice {
    private int number;

    public Dice(int number) {
        this.number = number;
    }
}
