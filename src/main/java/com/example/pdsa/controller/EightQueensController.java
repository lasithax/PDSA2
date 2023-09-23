package com.example.pdsa.controller;

import com.example.pdsa.model.eightqueens.EightQueens;
import com.example.pdsa.repository.EightQueensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/eight-queens")
public class EightQueensController {

    @Autowired
    private EightQueensService eightQueensService;

    @GetMapping("/all")
    public ResponseEntity<List<EightQueens>> allEightQueens(){
        return new ResponseEntity<>(eightQueensService.all(), HttpStatus.OK);
    }
}
