package com.example.pdsa.service;

import com.example.pdsa.logic.KnightsTourGame;
import com.example.pdsa.model.knightstour.KnightsTour;
import com.example.pdsa.model.knightstour.KnightsTourResponse;
import com.example.pdsa.repository.KnightsTourRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnightsTourService {
    @Autowired
    private KnightsTourRepository knightsTourRepo;

    private KnightsTourGame ktGame;

    private String username;


    public KnightsTourGame.Position start(String username){
        this.username = username;
        ktGame = new KnightsTourGame();
        return ktGame.getStartingPosition();
    }
    public KnightsTourGame.Result verify(KnightsTourResponse knightsTourResponse){
        KnightsTourGame.Result result = ktGame.verify(knightsTourResponse.getResponse());
        if (result.result.equals("WON")){
            addNewResponse(knightsTourResponse);
        }
        return result;
    }
    public void addNewResponse(KnightsTourResponse knightsTourResponse) {
         knightsTourRepo.save(new KnightsTour(
                new ObjectId(),
                knightsTourResponse.getName(),
                knightsTourResponse.getResponse()
            )
        );
    }
}
