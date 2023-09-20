package com.example.pdsa.controller;

import com.example.pdsa.model.eightqueens.EightQueens;
import com.example.pdsa.repository.EightQueenService;
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
    private EightQueenService eightQueenService;

    @GetMapping("/all")
    public ResponseEntity<List<EightQueens>> allEightQueens(){
        return new ResponseEntity<>(eightQueenService.all(), HttpStatus.OK);
    }
}
