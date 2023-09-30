package com.example.pdsa.model.eightqueens;

public class EightQueensResponse {
    private String name;
    private int[] response;

    public EightQueensResponse() {
    }

    public EightQueensResponse(String name, int[] response) {
        this.name = name;
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public EightQueensResponse setName(String name) {
        this.name = name;
        return this;
    }

    public int[] getResponse() {
        return response;
    }

    public EightQueensResponse setResponse(int[] response) {
        this.response = response;
        return this;
    }
}
