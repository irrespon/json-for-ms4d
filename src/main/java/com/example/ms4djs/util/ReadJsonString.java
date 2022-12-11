package com.example.ms4djs.util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ReadJsonString {

    public JSONObject convertJsonString(String jsonString){
            return   new JSONObject(jsonString);
    }
}
