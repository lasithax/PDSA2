package com.example.pdsa.repository;

import com.example.pdsa.model.eightqueens.EightQueens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EightQueenService {
    @Autowired
    private EightQueenRepository eightQueenRepository;

    public List<EightQueens> all() {
        return eightQueenRepository.findAll();
    }
}
