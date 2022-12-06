package com.example.ms4djs.controller;

import com.example.ms4djs.service.ServiceGetJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewDataController {

    @Autowired
    ServiceGetJSON serviceGetJSON;

    @GetMapping("/getSession")
    public ResponseEntity getSession(){
        String sessionId = serviceGetJSON.getSession("\"\"");
        serviceGetJSON.getSubId(sessionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //@GetMapping("/viewTable")


}
