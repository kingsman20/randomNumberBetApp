package com.example.randomBetApp.controller;

import com.example.randomBetApp.model.BetRequest;
import com.example.randomBetApp.model.BetResponse;
import com.example.randomBetApp.service.BetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Validated
public class BetController {

    @Autowired
    private BetService betService;

    // Home api
    @GetMapping()
    public ResponseEntity<String> bet() {
        return ResponseEntity.ok("Welcome to our random number betting service");
    }

    @PostMapping("/bet")
    public ResponseEntity<BetResponse> placeBet(@Valid @RequestBody BetRequest request) {
        Double winAmount = betService.calculateWin(request.getNumber(), request.getBet());
        return ResponseEntity.ok(new BetResponse(winAmount));
    }
}
