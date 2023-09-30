package com.example.pdsa.repository;

import com.example.pdsa.model.shortestpath.ShortestPath;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortestPathRepository extends MongoRepository<ShortestPath, ObjectId> {
}
