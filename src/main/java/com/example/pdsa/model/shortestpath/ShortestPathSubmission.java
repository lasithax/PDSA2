package com.example.pdsa.model.shortestpath;

import java.util.List;

public class ShortestPathSubmission {
    public List<Integer> distances;
    public List<List<Integer>> paths;

    public ShortestPathSubmission() {
    }

    public ShortestPathSubmission(List<Integer> distances, List<List<Integer>> paths) {
        this.distances = distances;
        this.paths = paths;
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public void setDistances(List<Integer> distances) {
        this.distances = distances;
    }

    public List<List<Integer>> getPaths() {
        return paths;
    }

    public void setPaths(List<List<Integer>> paths) {
        this.paths = paths;
    }
}
