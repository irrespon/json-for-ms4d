package com.example.ms4djs.CRUDDao;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

//возвращает jsonObject через JsonParser, который считывает файл из pathFile
@Component
public class LoadFileImpl implements LoadFile {
    JSONObject jsonObject = new JSONObject();
    JSONParser parser = new JSONParser();

    @Override
    public JSONObject loadJSON(String pathFile) {
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(pathFile));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public String loadString(String pathFile) {
        return null;
    }
}
