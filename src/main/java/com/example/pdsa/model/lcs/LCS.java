package com.example.pdsa.model.lcs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "lcs")
public class LCS {
    private ObjectId _id;
    private String name;
    private List<String> strings;
    private String response;

    public LCS() {
    }

    public LCS(ObjectId _id, String name, List<String> strings, String response) {
        this._id = _id;
        this.name = name;
        this.strings = strings;
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

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
