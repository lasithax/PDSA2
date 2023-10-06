package com.example.pdsa.controller;

import com.example.pdsa.service.LCSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "http://localhost:8081"})
@RequestMapping("/lcs")
public class LCSController {

    @Autowired
    private LCSService lcsService;

    @GetMapping("/start")
    // /lcs/start?username=...
    public ResponseEntity<Map<String, String>> start(@RequestParam String username){
        return new ResponseEntity<>(lcsService.start(username), HttpStatus.OK);
    }

    @PostMapping("/submit")
    // /lcs/submit?answer=...
    public ResponseEntity<Map<String, String>> submit(@RequestParam String answer){
        return new ResponseEntity<>(lcsService.checkAnswer(answer), HttpStatus.OK);
    }
}
