package com.example.aspectdemo.service;


import com.example.aspectdemo.domain.ResponseCodeTO;
import com.example.aspectdemo.exceptions.AspectDemoException;
import com.example.aspectdemo.model.AspectDemoTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AspectDemoService {

    private AspectDemoTO aspectDemoTO;

    public AspectDemoService(AspectDemoTO employee) {
        this.aspectDemoTO = employee;
    }

    public AspectDemoTO getEmployee(Integer option) throws AspectDemoException {
        AspectDemoTO dummyEmployee = new AspectDemoTO();
        dummyEmployee.setDemoMessage("Number 6: I am a man not a number!");

        switch (option) {
            case 1:
                throw new RuntimeException("Option 1 Runtime exception");
            case 2:
                ResponseCodeTO responseCodeTO = new ResponseCodeTO("Call Failed with custon exception", HttpStatus.I_AM_A_TEAPOT, -1);
                throw new AspectDemoException(responseCodeTO);
            default:
                return dummyEmployee;
        }
    }

}