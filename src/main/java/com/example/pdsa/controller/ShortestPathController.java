package com.example.pdsa.controller;

import com.example.pdsa.model.shortestpath.ShortestPathGameData;
import com.example.pdsa.model.shortestpath.ShortestPathSubmission;
import com.example.pdsa.service.ShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/submit")
    public ResponseEntity<String> submit(@RequestBody ShortestPathSubmission submission){

        return new ResponseEntity<>(shortestPathService.submit(submission), HttpStatus.OK);
    }
}
