package com.example.ms4djs.repository;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class FileJsonObjImpl implements FileJsonObj{

    JSONObject jsonObject = new JSONObject();
    JSONParser parser = new JSONParser();

    @Override
    public JSONObject getJsonObjFromFile(String pathFile) {
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(pathFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    }
