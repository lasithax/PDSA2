package com.example.pdsa.service;
import com.example.pdsa.logic.TicTacToeGame;
import com.example.pdsa.model.tictactoe.TicTacToe;
import com.example.pdsa.repository.TicTacToeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeService {

    @Autowired
    private TicTacToeRepository tttRepo;
    private TicTacToeGame tttGame;

    public void start(String username){
        tttGame = new TicTacToeGame(username);
    }

    public TicTacToeGame.Response play(int[] coordinate){
        TicTacToeGame.Response response = tttGame.playerMove(coordinate);
        if(!response.gameState.equals("In play")){
            saveResult(tttGame.getResult());
        }

        return response;
    }

    public void saveResult(TicTacToe result){
        tttRepo.save(result);
    }
}
