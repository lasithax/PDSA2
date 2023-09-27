package com.example.pdsa.service;
import com.example.pdsa.repository.TicTacToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeService {

    @Autowired
    private TicTacToeRepository ticTacToeRepo;
}
