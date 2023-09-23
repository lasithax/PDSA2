package com.example.pdsa.repository;

import com.example.pdsa.model.eightqueens.EightQueens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
}
