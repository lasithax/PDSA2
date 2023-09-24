package com.example.pdsa.controller;

import com.example.pdsa.model.eightqueens.EightQueens;
import com.example.pdsa.model.eightqueens.EightQueensResponse;
import com.example.pdsa.service.EightQueensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eight-queens")
public class EightQueensController {

    @Autowired
    private EightQueensService eightQueensService;

    // get all saved responses
    @GetMapping("/all")
    public ResponseEntity<List<EightQueens>> all(){
        return new ResponseEntity<>(eightQueensService.all(), HttpStatus.OK);
    }

    // add new response
    @PostMapping("/add-response")
    public ResponseEntity<EightQueens> addNewResponse(@RequestBody EightQueensResponse eightQueensResponse){

        return new ResponseEntity<>(eightQueensService.addNewResponse(eightQueensResponse), HttpStatus.CREATED);
    }
}
