package com.example.pdsa.model.eightqueens;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "eight_queens_solutions")
public class EightQueensSolution {
    private int _id;
    private List<String> arrangement;
    private boolean identified;

    public EightQueensSolution() {
    }

    public EightQueensSolution(int _id, List<String> arrangement, boolean identified) {
        this._id = _id;
        this.arrangement = arrangement;
        this.identified = identified;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public List<String> getArrangement() {
        return arrangement;
    }

    public void setArrangement(List<String> arrangement) {
        this.arrangement = arrangement;
    }

    public boolean isIdentified() {
        return identified;
    }

    public void setIdentified(boolean identified) {
        this.identified = identified;
    }
}
