package com.example.aspectdemo.common;

public enum ReturnCode {

    SUCCESS(0, "Success"), FAILURE(-1, "Failure"), EXCEPTION(-2, "Exception"), NO_ROWS_FOUND(-3, "No records found"), INVALID_PARAMETERS(
            -4, "Invalid paramater passed"), UNSUPPORTED_VERSION(-5, "Unsupported version");

    private final int code;
    private String message;

    private ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ReturnCode fromCode(int code) {
        for (ReturnCode returnCode : values()) {
            if (returnCode.code == code) {
                return returnCode;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
