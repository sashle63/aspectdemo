package com.example.aspectdemo.domain;


import org.springframework.http.HttpStatus;

public class ResponseCodeTO {
    protected int responseCode;
    protected String message;
    private HttpStatus httpStatus;

    public ResponseCodeTO() {
    }

    public ResponseCodeTO(String message, HttpStatus httpStatus, int code) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.responseCode = code;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
