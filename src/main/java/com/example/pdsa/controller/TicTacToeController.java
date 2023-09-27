package com.example.pdsa.controller;

import com.example.pdsa.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tictactoe")
public class TicTacToeController {

    @Autowired
    private TicTacToeService ticTacToeService;

    @GetMapping("/start")
    public String start(){

        return "start";
    }




}
