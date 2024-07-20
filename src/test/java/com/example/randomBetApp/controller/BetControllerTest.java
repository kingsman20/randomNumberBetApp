package com.example.randomBetApp.controller;

import com.example.randomBetApp.model.BetRequest;
import com.example.randomBetApp.service.BetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BetController.class)
class BetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BetService betService;

    @Test
    void testPlaceBet() throws Exception {
        BetRequest request = new BetRequest();
        request.setNumber(50);
        request.setBet(40.5);

        when(betService.calculateWin(50, 40.5)).thenReturn(80.19);

        mockMvc.perform(post("/api/v1/bet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"number\":50,\"bet\":40.5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.winAmount").value(80.19));
    }

    @Test
    void testPlaceBetWithInvalidRequest() throws Exception {
        mockMvc.perform(post("/api/v1/bet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"number\":150,\"bet\":-5}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.number").value("Number must be at most 100"))
                .andExpect(jsonPath("$.bet").value("Bet must be at least 1"));
    }

    @Test
    void testPlaceBetWithMissingFields() throws Exception {
        mockMvc.perform(post("/api/v1/bet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.number").value("Number must not be null"))
                .andExpect(jsonPath("$.bet").value("Bet must not be null"));
    }
}