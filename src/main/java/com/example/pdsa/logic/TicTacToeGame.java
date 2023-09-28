package com.example.pdsa.logic;

import com.example.pdsa.model.tictactoe.TicTacToe;
import com.example.pdsa.service.TicTacToeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

public class TicTacToeGame {
    public static class Response {
        public int[] computerMove;
        public String gameState; // "Won", "Lost", "Draw", "In play"

        public String error;
        public Response(int[] computerMove, String gameState, String error) {
            this.computerMove = computerMove;
            this.gameState = gameState;
            this.error = error;
        }
    }

    private String username;
    private String result;
    private final char sign = 'X';
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    boolean isPlayerTurn = true; // True if it's the player's turn, false if AI's turn
    boolean gameInProgress = true;
    int totalMoves = 0;

    public TicTacToeGame(String username) {
        this.username = username;
    }

    public Response playerMove(int[] coordinate) {
        if (board[coordinate[0]][coordinate[1]] != ' ' || coordinate[0] > 2 || coordinate[1] > 2) {
            return new Response(new int[]{}, "In play", "Invalid move");
        }

        board[coordinate[0]][coordinate[1]] = 'X';
        totalMoves++;
        return getResponse();
    }

    private Response getResponse() {
        int[] AIMove = {};
        String gameState = checkGameState();

        if(gameInProgress){
            AIMove = getAIMove(board, 'O');
            gameState = checkGameState();
            totalMoves++;
        }

        return new Response(AIMove, gameState, null);
    }

    private String checkGameState() {
        if (checkWin(board, 'X')) {
            gameInProgress = false;
            return "Won";
        } else if (checkWin(board, 'O')) {
            gameInProgress = false;
            return "Lost";
        } else if (totalMoves == 9) {
            gameInProgress = false;
            return "Draw";
        } else {
            return "In play";
        }
    }

    private int[] getAIMove(char[][] board, char currentPlayer) {
        int[] bestMove = minimax(board, currentPlayer);
        int row = bestMove[0];
        int col = bestMove[1];

        board[row][col] = currentPlayer;
        return bestMove;
    }

    private static boolean checkWin(char[][] board, char currentPlayer) {
        // Check for a win condition (rows, columns, diagonals)
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Check rows
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Check columns
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Check diagonal (top-left to bottom-right)
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Check diagonal (top-right to bottom-left)
        }
        return false;
    }

    private static int evaluate(char[][] board, char currentPlayer) {
        // Evaluation function for the minimax algorithm
        int score = 0;

        // Check rows, columns, and diagonals for winning opportunities
        for (int i = 0; i < 3; i++) {

            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == ' ') {
                score += 10;
            }
            if (board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[0][i] == ' ') {
                score += 10;
            }
            if (board[0][i] == ' ' && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                score += 10;
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == ' ') {
            score += 10;
        }
        if (board[1][1] == currentPlayer && board[2][2] == currentPlayer && board[0][0] == ' ') {
            score += 10;
        }
        if (board[0][0] == ' ' && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            score += 10;
        }

        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == ' ') {
            score += 10;
        }
        if (board[1][1] == currentPlayer && board[2][0] == currentPlayer && board[0][2] == ' ') {
            score += 10;
        }
        if (board[0][2] == ' ' && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            score += 10;
        }

        return score;
    }

    private static int[] minimax(char[][] board, char currentPlayer) {
        // Implement the minimax algorithm with alpha-beta pruning
        // This function should return the best move for the AI
        // Use the evaluate function to assign scores to board positions


        // Placeholder for the best move
        int[] bestMove = { -1, -1 };
        int bestScore = Integer.MIN_VALUE;

        // Iterate through the board to find the best move
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = currentPlayer;
                    int score = minimaxHelper(board, 0, false, currentPlayer);
                    board[i][j] = ' '; // Undo the move

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        return bestMove;
    }

    private static int minimaxHelper(char[][] board, int depth, boolean isMaximizing, char currentPlayer) {
        // Implement the minimax algorithm with alpha-beta pruning recursively
        // Use the evaluate function to assign scores to board positions

        // Check for terminal states (win/draw)
        if (checkWin(board, 'X')) {
            return -10;
        }
        if (checkWin(board, 'O')) {
            return 10;
        }
        if (isBoardFull(board)) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = currentPlayer;
                        int score = minimaxHelper(board, depth + 1, false, currentPlayer);
                        board[i][j] = ' '; // Undo the move
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = (currentPlayer == 'X') ? 'O' : 'X';
                        int score = minimaxHelper(board, depth + 1, true, currentPlayer);
                        board[i][j] = ' '; // Undo the move
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private static boolean isBoardFull(char[][] board) {
        // Check if the board is full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public TicTacToe getResult(){
        //convert char board to String board
        String[][] stringBoard = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                stringBoard[i][j] = String.valueOf(board[i][j]);
            }
        }

        return new TicTacToe(new ObjectId(), username, result, String.valueOf(sign), stringBoard);
    }
}
