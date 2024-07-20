package com.example.randomBetApp.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BetService {
    private final Random random = new Random();

    public Double calculateWin(Integer number, Double bet) {
        int serverNumber = random.nextInt(100) + 1;
        if (number > serverNumber) {
            return bet * (99.0 / (100 - number));
        }
        return 0.0;
    }
}
