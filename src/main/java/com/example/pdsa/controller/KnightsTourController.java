package com.example.pdsa.controller;

import com.example.pdsa.logic.KnightsTourGame;
import com.example.pdsa.model.knightstour.KnightsTourResponse;
import com.example.pdsa.service.KnightsTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/knightstour")
public class KnightsTourController {
    @Autowired
    private KnightsTourService knightsTourService;

    @GetMapping("/start")
    public ResponseEntity<KnightsTourGame.Position> start(){
        return new ResponseEntity<>(knightsTourService.start(), HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<KnightsTourGame.Result> verify(@RequestBody KnightsTourResponse knightsTourResponse){
        KnightsTourGame.Result result = knightsTourService.verify(knightsTourResponse);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
