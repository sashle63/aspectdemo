package com.example.aspectdemo.model;

import org.springframework.stereotype.Component;

@Component
public class AspectDemoTO {

    private String demoMessage;

    public String getDemoMessage() {
        return demoMessage;
    }

    public void setDemoMessage(String demoMessage) {
        this.demoMessage = demoMessage;
    }

}

