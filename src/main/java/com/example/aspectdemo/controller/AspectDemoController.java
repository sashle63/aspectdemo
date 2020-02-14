package com.example.aspectdemo.controller;

import com.example.aspectdemo.exceptions.AspectDemoException;
import com.example.aspectdemo.logging.AfterThrowingLog;
import com.example.aspectdemo.logging.AroundLog;
import com.example.aspectdemo.service.AspectDemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/aspectdemo")
public class AspectDemoController {

    private AspectDemoService aspectDemoService;

    public AspectDemoController(AspectDemoService aspectDemoService) {
        this.aspectDemoService = aspectDemoService;
    }

    @AroundLog
    @AfterThrowingLog
    @RequestMapping(value = "/message/{choice}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<?> getMessage(@PathVariable(value = "choice") Integer choice) {
        String errorMessage = "Aspect Message controller failed";
        try {
            return ResponseEntity.ok().body(aspectDemoService.getEmployee(choice));
        } catch (AspectDemoException ade) {
            return ResponseEntity.status(ade.getResponseTO().getHttpStatus()).body(ade.getResponseTO().getMessage());
        } catch (Exception ex) {   // We only get here if something truly unexpected occurred
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
