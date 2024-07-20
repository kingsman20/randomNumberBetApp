package com.example.randomBetApp.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BetServiceTest {

    private final BetService gameService = new BetService();

    @Test
    void testCalculateWin() {
        Double win = gameService.calculateWin(50, 40.5);
        assertNotNull(win);
    }

    @Test
    void testCalculateWinWhenNumberIsLower() {
        Double win = gameService.calculateWin(10, 50.0);
        assertEquals(0.0, win);
    }

}
