package com.example.pdsa.model.eightqueens;

//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "eight_queens")
public class EightQueens {

    @Id
    private ObjectId _id;
    private String name;
    private List<String> response;

    public EightQueens() {
    }

    public EightQueens(ObjectId _id, String name, List<String> response) {
        this._id = _id;
        this.name = name;
        this.response = response;
    }

    public ObjectId get_id() {
        return _id;
    }

    public EightQueens set_id(ObjectId _id) {
        this._id = _id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EightQueens setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getResponse() {
        return response;
    }

    public EightQueens setResponse(List<String> response) {
        this.response = response;
        return this;
    }
}
