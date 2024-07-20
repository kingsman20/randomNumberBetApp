package com.example.randomBetApp.model;

public class BetResponse {

    private Double winAmount;

    public BetResponse(Double winAmount) {
        this.winAmount = winAmount;
    }

    public Double getWinAmount() {
        return winAmount;
    }

    public void setWinAmount(Double winAmount) {
        this.winAmount = winAmount;
    }
}
