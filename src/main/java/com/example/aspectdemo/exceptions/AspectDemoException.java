package com.example.aspectdemo.exceptions;

import com.example.aspectdemo.domain.ResponseCodeTO;

public class AspectDemoException extends Throwable {

    private static final long serialVersionUID = 1L;
    private ResponseCodeTO responseTO;

    public AspectDemoException() {
    }

    public AspectDemoException(ResponseCodeTO responseTO) {
        super(responseTO.getMessage());

        this.responseTO = responseTO;
    }

    public ResponseCodeTO getResponseTO() {
        return responseTO;
    }

    public void setResponseTO(ResponseCodeTO responseTO) {
        this.responseTO = responseTO;
    }
}
