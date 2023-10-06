package com.example.pdsa.model.shortestpath;

import java.util.List;

public class ShortestPathSubmission {
    public List<String> distances;
    public List<String> paths;

    public ShortestPathSubmission() {
    }

    public ShortestPathSubmission(List<String> distances, List<String> paths) {
        this.distances = distances;
        this.paths = paths;
    }

    public List<String> getDistances() {
        return distances;
    }

    public void setDistances(List<String> distances) {
        this.distances = distances;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
