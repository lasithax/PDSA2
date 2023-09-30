package com.example.pdsa.model.shortestpath;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "shortest_path")
public class ShortestPath {
    public class Distance{
        public int distance;
        public List<String> path;

        public Distance(){
        }

        public Distance(int distance, List<String> path){
            this.distance = distance;
            this.path = path;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public List<String> getPath() {
            return path;
        }

        public void setPath(List<String> path) {
            this.path = path;
        }
    }

    public ObjectId _id;
    public String username;
    public String startingCity;
    public List<List<Integer>> distances;
    public Map<String, Distance> response;

    public ShortestPath(){
    }

    public ShortestPath(ObjectId _id, String username, String startingCity, List<List<Integer>> distances, Map<String, Distance> response){
        this._id = _id;
        this.username = username;
        this.startingCity = startingCity;
        this.distances = distances;
        this.response = response;
    }
}
