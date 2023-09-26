package com.example.pdsa.repository;

import com.example.pdsa.model.knightstour.KnightsTour;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnightsTourRepository extends MongoRepository<KnightsTour, ObjectId> {
}
