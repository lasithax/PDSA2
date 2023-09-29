package com.example.pdsa.service;

import com.example.pdsa.logic.LCSGame;
import com.example.pdsa.model.lcs.LCS;
import com.example.pdsa.repository.LCSRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LCSService {

    @Autowired
    private LCSRepository lcsRepo;

    private LCSGame lcsGame;
    private String username;
    public Map<String, String> start(String username){
        this.username = username;
        lcsGame = new LCSGame();
        return lcsGame.getStrings();
    }

    public Map<String, String> checkAnswer(String answer){
        boolean isCorrect = lcsGame.checkAnswer(answer);

        if (isCorrect){
            addNewResponse(username, lcsGame.getStrings(), answer);
        }

        return isCorrect ? Map.of("result", "Correct!") : Map.of("result", "Incorrect!");
    }

    public void addNewResponse(String username, Map<String, String> strings, String response){
        lcsRepo.save(new LCS(new ObjectId(), username, strings, response));
    }
}
