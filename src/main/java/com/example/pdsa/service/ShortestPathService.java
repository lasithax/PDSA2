package com.example.pdsa.service;

import com.example.pdsa.logic.ShortestPathGame;
import com.example.pdsa.model.shortestpath.ShortestPathGameData;
import com.example.pdsa.repository.ShortestPathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShortestPathService {

    @Autowired
    private ShortestPathRepository shortestPathRepo;

    private ShortestPathGame spGame;

    private String username;

    public ShortestPathGameData start(){
        this.username = username;
        spGame = new ShortestPathGame();

        int[][] matrix = spGame.getAdjacencyMatrix();
        List<List<Integer>> distances = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                row.add(matrix[i][j]);
            }
            distances.add(row);
        }

        // convert vertex index value to Alphabet letter
        char startingCity = (char) (spGame.getSourceVertex() + 65);

        return new ShortestPathGameData(String.valueOf(startingCity), distances);
    }
}
