package com.example.pdsa.repository;

import com.example.pdsa.model.tictactoe.TicTacToe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicTacToeRepository extends MongoRepository<TicTacToe, ObjectId> {
}
