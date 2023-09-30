package com.example.pdsa.controller;

import com.example.pdsa.model.shortestpath.ShortestPathGameData;
import com.example.pdsa.service.ShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@RequestMapping("/shortestpath")
public class ShortestPathController {

    @Autowired
    private ShortestPathService shortestPathService;

    @GetMapping("/start")
    public ResponseEntity<ShortestPathGameData> start(){
        return new ResponseEntity<>(shortestPathService.start(), HttpStatus.OK);
    }
}
