package com.example.hw2_rest_api.model;

public class ResponseMessage {
    
    private String message;
    private int statusCode; // Add this field for the status code

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage(String message, int statusCode) { // New constructor
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() { // Getter for statusCode
        return statusCode;
    }

    public void setStatusCode(int statusCode) { // Setter for statusCode
        this.statusCode = statusCode;
    }
}