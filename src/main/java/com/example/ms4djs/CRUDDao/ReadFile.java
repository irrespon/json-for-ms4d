package com.example.ms4djs.CRUDDao;

import org.json.simple.JSONObject;

public interface ReadFile {
    void readJSONFile(JSONObject jsonObject);
    void readCSVFile(String stringObject);
}
