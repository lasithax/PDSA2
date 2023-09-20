package com.example.pdsa.repository;

import com.example.pdsa.model.eightqueens.EightQueens;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EightQueenRepository extends MongoRepository<EightQueens, ObjectId> {
}
