package com.example.ms4djs.service;

import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;


public interface ServiceCRUDFile {
    boolean save(MultipartFile file);
    JSONObject loadJSON(String pathFile);
    String loadString(String pathFile);
    void readJSONFile(JSONObject jsonObject);
    void readStringFile(String stringObject);
}
