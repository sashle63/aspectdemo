package com.example.aspectdemo.exceptions;


import com.example.aspectdemo.common.ReturnCode;
import com.example.aspectdemo.domain.ResponseCodeTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class ControllerExceptionHandler {
//public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(HttpClientErrorException.class)
//    public final ResponseEntity<ResponseCodeTO> handleClientErrorException(HttpClientErrorException ex) {
//        ResponseCodeTO to;
//        to = new ResponseCodeTO(ex.getResponseBodyAsString(), ex.getStatusCode(), ReturnCode.EXCEPTION.getCode());
//        return new ResponseEntity<>(to, getJsonHeaders(), ex.getStatusCode());
//    }
//
//    @ExceptionHandler(HttpServerErrorException.class)
//    public final ResponseEntity<ResponseCodeTO> handleServerErrorException(HttpServerErrorException ex) {
//        ResponseCodeTO to;
//        to = new ResponseCodeTO(ex.getMessage(), HttpStatus.BAD_GATEWAY, ReturnCode.EXCEPTION.getCode());
//        return new ResponseEntity<>(to, getJsonHeaders(), HttpStatus.BAD_GATEWAY);
//    }
//
//    @ExceptionHandler(AspectDemoException.class)
//    public final ResponseEntity<ResponseCodeTO> handleProjectGatewayException(AspectDemoException ex) {
//        return new ResponseEntity<>(ex.getResponseTO(), getJsonHeaders(), ex.getResponseTO().getHttpStatus());
//    }
//
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<ResponseCodeTO> handleException(Exception ex) {
//        return new ResponseEntity<>(new ResponseCodeTO(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ReturnCode.EXCEPTION.getCode()),
//                getJsonHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    private static HttpHeaders getJsonHeaders() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
//        return headers;
//    }


}
