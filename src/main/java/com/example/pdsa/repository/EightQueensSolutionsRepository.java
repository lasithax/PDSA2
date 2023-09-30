package com.example.pdsa.repository;

import com.example.pdsa.model.eightqueens.EightQueensSolution;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface EightQueensSolutionsRepository extends MongoRepository<EightQueensSolution, Integer> {

    @Query("{_id: ?0}")
    @Update("{identified: ?1}")
    int updateById(int id, boolean identified);
    //TODO: fix bug where method removes solution from document
}
