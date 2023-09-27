package com.example.pdsa.model.eightqueens;

import java.util.List;

public class EightQueensResponse {
    private String name;
    private List<String> response;
    public EightQueensResponse() {
    }
    public EightQueensResponse(String name, List<String> response) {
        this.name = name;
        this.response = response;
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