package com.example.pdsa.service;

import com.example.pdsa.logic.ShortestPathGame;
import com.example.pdsa.model.shortestpath.ShortestPathAlgorithm;
import com.example.pdsa.model.shortestpath.ShortestPathGameData;
import com.example.pdsa.model.shortestpath.ShortestPathSubmission;
import com.example.pdsa.repository.ShortestPathAlgorithmRepository;
import com.example.pdsa.repository.ShortestPathRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShortestPathService {

    @Autowired
    private ShortestPathRepository shortestPathRepo;

    @Autowired
    private ShortestPathAlgorithmRepository shortestPathAlgorithmRepo;

    private ShortestPathGame spGame;
    private ShortestPathGame.AllResult result;

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
        saveAlgoTimes();

        return new ShortestPathGameData(String.valueOf(startingCity), distances);
    }

    public String submit(ShortestPathSubmission submission){
        // {"25", "35", ...} -> {25, 35, ...}
        List<String> stringDistances = submission.getDistances();
        // { "A,B,C", "A,B,D", ...} -> { {0,1,2}, {0,1,3}, ...}
        List<String> charPaths = submission.getPaths();

        List<Integer> distances = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();

        for(String s : stringDistances) {
            distances.add(Integer.valueOf(s));
        }

        for(String s : charPaths) {
            List<Integer> path = new ArrayList<>();
            for(String c : s.split(",")) {
                path.add((int) c.charAt(0) - 65);
            }
            paths.add(path);
        }


        // all paths must start with source vertex
        if (distances.equals(result.distanceList) && paths.equals(result.pathList)) {
            return "Correct";
        } else {
            return "Incorrect";
        }
    }
    public void saveAlgoTimes(){
        result = spGame.getAllResult();
        shortestPathAlgorithmRepo.save(new ShortestPathAlgorithm(
                new ObjectId(),
                (int) result.bellmanFordTime,
                (int) result.dijkstraTime
            )
        );
    }
}
