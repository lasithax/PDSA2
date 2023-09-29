package com.example.pdsa.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class KnightsTourGame {

    public class Position {
        public int[] matrixPosition;
        public String chessPosition;
        public Position(int[] matrixPosition, String chessPosition) {
            this.matrixPosition = matrixPosition;
            this.chessPosition = chessPosition;
        }
    }

    public class Result {
        //TODO: this class can be converted into a Map<String, String>
        public String result;
        public String comment;
        public Result(String result, String comment) {
            this.result = result;
            this.comment = comment;
        }
    }

    private int[][] board = new int[8][8];
    private int[] startingPosition = new int[2];

    Logger logger = LoggerFactory.getLogger(KnightsTourGame.class);
    String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H"};
    public KnightsTourGame(){
        generateRandomPosition();
    }

    public Position getStartingPosition() {
        String chessPosition = letters[startingPosition[0]] + (startingPosition[1] + 1);

        //{"matrixPosition": [0, 0], "chessPosition": "A1"}
        return new Position(startingPosition, chessPosition);
    }

    // traverse through each row in board and set all values to 0
    private void initializeBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                this.board[i][j] = 0;
            }
        }
    }

    // generate random position for knight to start
    private void generateRandomPosition(){
        startingPosition[0] = (int)(Math.random() * 8);
        startingPosition[1] = (int)(Math.random() * 8);
    }

    public Result verify(List<String> chessMoves) {
        initializeBoard();
        int[][] moves = new int[chessMoves.size() + 1][2];

        // insert starting position into moves array
        moves[0] = startingPosition;

        // extract the letter and number from each move and store in moves array
        for (String move : chessMoves) {
            int letter = move.toUpperCase().charAt(0);
            int number = (move.charAt(1)-'0')-1;

            if(number < 0 || number > 7) {
                return new Result("LOST", move + " is not a valid chessboard position");
            }

            if(letter < 65 || letter > 72) {
                return new Result("LOST", move + " is not a valid chessboard position");
            }

            int[] moveCoordinate = {letter-65 , number};
            moves[chessMoves.indexOf(move) + 1] = moveCoordinate;
        }

        logger.info("moves: " + Arrays.deepToString(moves));

        // set starting position to 1
        board[startingPosition[0]][startingPosition[1]] = 1;

        // traverse through each move and check if it is a legal move
        for(int i = 0; i < moves.length-1; i++) {
            if(isLegalMove(moves[i], moves[i+1])) {
                // if legal move, check if position is already visited
                if(board[moves[i+1][0]][moves[i+1][1]] == 1) {
                    return new Result("LOST", "You have visited " + chessMoves.get(i) + " twice");
                } else {
                    // if not visited, set position to 1
                    board[moves[i+1][0]][moves[i+1][1]] = 1;
                }
            } else {
                return new Result("LOST", "You made an illegal move at " + chessMoves.get(i));
            }
        }

        // check if all positions have been visited
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 0){
                    return new Result("LOST", "You have not visited all positions yet");
                }
            }
        }

        return new Result("WON", "Success! You have visited all positions");
    }

    private boolean isLegalMove(int[] position, int[] move){

        if(
            // a +/- 1 and b +/- 2
            ((move[0] == position[0]+1 || move[0] == position[0]-1) && (move[1] == position[1]+2 || move[1] == position[1]-2)) ||
            // a +/- 2 and b +/- 1
            ((move[0] == position[0]+2 || move[0] == position[0]-2) && (move[1] == position[1]+1 || move[1] == position[1]-1))
        ) {
            return true;
        }
        else {
            return false;
        }

    }

}
