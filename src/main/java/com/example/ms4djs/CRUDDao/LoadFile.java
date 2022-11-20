package com.example.ms4djs.CRUDDao;

import org.json.simple.JSONObject;

public interface LoadFile {
    JSONObject loadJSON(String pathFile);
    String loadString(String pathFile);
}
