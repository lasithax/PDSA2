package com.example.pdsa.model.tictactoe;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tic_tac_toe")
public class TicTacToe {
    private ObjectId _id;
    private String name;
    private String result;
    private String sign;
    private String[][] board;

    public TicTacToe() {
    }

    public TicTacToe(ObjectId _id, String name, String result, String sign, String[][] board) {
        this._id = _id;
        this.name = name;
        this.result = result;
        this.sign = sign;
        this.board = board;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}
