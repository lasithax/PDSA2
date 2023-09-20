package com.example.pdsa.model.shortestpath;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shortest_path")
public class ShortestPath {
  private String name;
}
