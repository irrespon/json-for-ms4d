package com.example.ms4djs.controller;

import com.example.ms4djs.repository.FileJsonObj;
import com.example.ms4djs.repository.FileJsonObjImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.annotation.PostConstruct;

import java.io.IOException;


@Controller
public class MainController {

    @Autowired
    FileJsonObj fileJsonObj;

    @GetMapping("/")
    public String viewIndex(){
        return "index";
    }


    public void test (String pathFile) throws IOException {

        String pathToFile = "c:\\Users\\korne\\AppData\\Roaming\\MPSSoft\\MasterSCADA4D1.2\\Debug_Проект 1\\АРМ 1\\PLC\\cfg\\VMInfo.json";
        Object obj = fileJsonObj.getJsonObjFromFile(pathToFile);
       JSONObject jsonpObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonpObject.get("projectTree");
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);

        JSONArray jsonArray1 = (JSONArray) jsonObject1.get("Childs");
        for (Object o: jsonArray1) {
            JSONObject jsonObject2 = (JSONObject) o;
            System.out.println("1 -> " + jsonObject2.get("Name"));

            JSONArray jsonArray2 = (JSONArray) jsonObject2.get("Childs");
            System.out.println("1 -> length = " + jsonArray2.size());
            for (Object o1: jsonArray2) {
                JSONObject jsonObject3 = (JSONObject) o1;
                System.out.println("  2 -> " + jsonObject3.get("Name"));

                JSONArray jsonArray3 = (JSONArray) jsonObject3.get("Childs");
                System.out.println("  2 -> length = " + jsonArray3.size());
            }
        }
    }
}
