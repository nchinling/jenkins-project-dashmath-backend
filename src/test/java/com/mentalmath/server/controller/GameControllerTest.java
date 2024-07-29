package com.mentalmath.server.controller;

import com.mentalmath.server.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GameControllerTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateQuestion() {
        String expectedQuestion = "What is 2 + 2?";
        when(gameService.generateQuestion()).thenReturn(expectedQuestion);

        ResponseEntity<String> responseEntity = gameController.generateQuestion();

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals("{\"question\":\"What is 2 + 2?\"}", responseEntity.getBody());
    }

    @Test
    void testCheckAnswer() throws Exception {
        double answer = 4.0;
        String markedQuestion = "Correct!";
        when(gameService.checkAnswer(answer)).thenReturn(markedQuestion);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("answer", String.valueOf(answer));

        ResponseEntity<String> responseEntity = gameController.checkAnswer(form);

        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals("{\"markedQuestion\":\"Correct!\"}", responseEntity.getBody());
    }
}
