package com.example.pdsa.model.lcs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "lcs")
public class LCS {
    private ObjectId _id;
    private String name;
    private Map<String, String> strings;
    private String response;

    public LCS() {
    }

    public LCS(ObjectId _id, String name, Map<String, String> strings, String response) {
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

    public Map<String, String> getStrings() {
        return strings;
    }

    public void setStrings(Map<String, String> strings) {
        this.strings = strings;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
