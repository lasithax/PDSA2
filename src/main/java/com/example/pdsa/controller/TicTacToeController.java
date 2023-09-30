package com.example.pdsa.controller;

import com.example.pdsa.logic.TicTacToeGame;
import com.example.pdsa.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@RequestMapping("/tictactoe")
public class TicTacToeController {

    @Autowired
    private TicTacToeService tictactoeService;

    @GetMapping("/start")
    public ResponseEntity<String> start(@RequestParam String username){
        // /tictactoe/start?username=Name
        tictactoeService.start(username);
        return new ResponseEntity<>("Game started", HttpStatus.OK);
    }

    @PostMapping("/play")
    public ResponseEntity<TicTacToeGame.Response> play(@RequestParam int[] coordinate){
        // /tictactoe/play?position=0,0
        return new ResponseEntity<>(tictactoeService.play(coordinate), HttpStatus.OK);
    }
}
