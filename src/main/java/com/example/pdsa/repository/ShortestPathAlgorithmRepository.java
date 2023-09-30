package com.example.pdsa.repository;

import com.example.pdsa.model.shortestpath.ShortestPathAlgorithm;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortestPathAlgorithmRepository extends MongoRepository<ShortestPathAlgorithm, ObjectId> {
}
