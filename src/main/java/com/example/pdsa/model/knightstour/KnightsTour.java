package com.example.pdsa.model.knightstour;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "knights_tour")
public class KnightsTour {

    private ObjectId _id;
    private String name;
    private List<String> response;

    public KnightsTour() {
    }

    public KnightsTour(ObjectId _id, String name, List<String> response) {
        this._id = _id;
        this.name = name;
        this.response = response;
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

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }
}
