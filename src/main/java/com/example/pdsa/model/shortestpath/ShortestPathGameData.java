package com.example.pdsa.model.shortestpath;

import java.util.List;

public class ShortestPathGameData {
    private String startingCity;
    private List<List<Integer>> distances;

    public ShortestPathGameData() {
    }

    public ShortestPathGameData(String startingCity, List<List<Integer>> distances) {
        this.startingCity = startingCity;
        this.distances = distances;
    }

    public String getStartingCity() {
        return startingCity;
    }

    public void setStartingCity(String startingCity) {
        this.startingCity = startingCity;
    }

    public List<List<Integer>> getDistances() {
        return distances;
    }

    public void setDistances(List<List<Integer>> distances) {
        this.distances = distances;
    }
}
