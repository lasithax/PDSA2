package com.example.pdsa.model.knightstour;

import java.util.List;

public class KnightsTourResponse {
    private String name;
    private List<String> response;

    public KnightsTourResponse() {
    }
    public KnightsTourResponse(String name, List<String> response) {
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
