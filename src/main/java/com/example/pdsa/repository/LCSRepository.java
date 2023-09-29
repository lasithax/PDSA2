package com.example.pdsa.repository;

import com.example.pdsa.model.lcs.LCS;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LCSRepository extends MongoRepository<LCS, ObjectId> {
}
