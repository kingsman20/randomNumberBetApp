package com.example.randomBetApp;

import com.example.randomBetApp.service.BetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RTPSimulationTest {

    @Autowired
    private BetService betService;

    @Test
    void testRTP() throws InterruptedException {
        int rounds = 1_000_000;
        double[] totalWin = {0.0};

        ExecutorService executor = Executors.newFixedThreadPool(24);
        IntStream.range(0, rounds).forEach(i -> executor.submit(() -> {
            double win = betService.calculateWin(50, 1.0);
            synchronized (totalWin) {
                totalWin[0] += win;
            }
        }));

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        double rtp = (totalWin[0] / rounds) * 100;
        System.out.printf("RTP: %.2f%%%n", rtp);
        assertTrue(rtp >= 90 && rtp <= 110); // Example range for RTP validation
    }
}
