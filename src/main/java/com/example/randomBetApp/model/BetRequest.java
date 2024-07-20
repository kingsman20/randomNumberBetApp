package com.example.randomBetApp.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BetRequest {

    @NotNull(message = "Number must not be null")
    @Min(value = 1, message = "Number must be at least 1")
    @Max(value = 100, message = "Number must be at most 100")
    private Integer number;

    @NotNull(message = "Bet must not be null")
    @Min(value = 1, message = "Bet must be at least 1")
    private Double bet;

    public Double getBet() {
        return bet;
    }

    public void setBet(Double bet) {
        this.bet = bet;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
