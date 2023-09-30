package com.example.pdsa.controller;

import com.example.pdsa.model.eightqueens.EightQueens;
import com.example.pdsa.model.eightqueens.EightQueensResponse;
import com.example.pdsa.service.EightQueensService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@RequestMapping("/eightqueens")
public class EightQueensController {

    @Autowired
    private EightQueensService eightQueensService;

    // call only once at the beginning of the programme
    // /eightqueens/start
    @GetMapping("/start")
    public ResponseEntity<String> start(){
        eightQueensService.start();
        return new ResponseEntity<>("Solutions initialized", HttpStatus.CREATED);
    }

    @PostMapping("/submit")
    public ResponseEntity<Map<String,String>> submit(@RequestBody EightQueensResponse eightQueensResponse){
        Logger logger = LoggerFactory.getLogger(EightQueensController.class);
        logger.info(Arrays.toString(eightQueensResponse.getResponse()));
        return new ResponseEntity<>(eightQueensService.checkResponse(eightQueensResponse), HttpStatus.OK);
    }
}
