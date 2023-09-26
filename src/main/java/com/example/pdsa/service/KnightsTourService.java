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

    public KnightsTour addNewResponse(KnightsTourResponse knightsTourResponse) {
        return knightsTourRepo.save(
                new KnightsTour(
                        new ObjectId(),
                        knightsTourResponse.getName(),
                        knightsTourResponse.getResponse()
                )
        );
    }

    public KnightsTourGame.Position start(){
        ktGame = new KnightsTourGame();
        return ktGame.getStartingPosition();
    }
    public KnightsTourGame.Result verify(KnightsTourResponse knightsTourResponse){
        return ktGame.verify(knightsTourResponse.getResponse());
    }
}
