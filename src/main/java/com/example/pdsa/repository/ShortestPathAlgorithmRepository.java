package com.example.pdsa.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortestPathAlgorithmRepository extends MongoRepository<ShortestPathAlgorithmRepository, ObjectId> {
}
