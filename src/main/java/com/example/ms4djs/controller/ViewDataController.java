package com.example.ms4djs.controller;

import com.example.ms4djs.service.ServiceGetJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewDataController {
    String sessionId ="";
    int subId = 0;
    @Autowired
    ServiceGetJSON serviceGetJSON;

    @GetMapping("/getSession")
    public ResponseEntity getSession(){
        sessionId = serviceGetJSON.getSession("\"\"","");
        subId = serviceGetJSON.getSubId(sessionId);
        serviceGetJSON.addMonitoredListItems(sessionId, subId, serviceGetJSON.getListPath());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getSession2")
    public ResponseEntity getSession2(){
        serviceGetJSON.getListItems(sessionId, subId, 0);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/getItems")
//    public ResponseEntity getItems(){
//
//    }


}
