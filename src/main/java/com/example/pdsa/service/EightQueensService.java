package com.example.pdsa.service;

import com.example.pdsa.model.eightqueens.EightQueens;
import com.example.pdsa.model.eightqueens.EightQueensResponse;
import com.example.pdsa.repository.EightQueensRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EightQueensService {
//    Logger logger = LoggerFactory.getLogger(EightQueensService.class);
    @Autowired
    private EightQueensRepository eightQueensRepo;

    public List<EightQueens> all() {
        List<EightQueens> list = eightQueensRepo.findAll();
//        list.forEach(item -> logger.info("Name: " + item.getName()));
        return eightQueensRepo.findAll();
    }

    public EightQueens addNewResponse(EightQueensResponse eightQueensResponse) {
        return eightQueensRepo.save(
                new EightQueens(
                        new ObjectId(),
                        eightQueensResponse.getName(),
                        eightQueensResponse.getResponse()
                )
        );
    }


}
