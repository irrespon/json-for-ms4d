package com.example.ms4djs.service;

import com.example.ms4djs.model.MasterScadaCSVObject;
import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ServiceCRUDFile {
    boolean save(MultipartFile file);
    JSONObject loadJSON(String pathFile);
    List<MasterScadaCSVObject> loadCSV(String pathFile);
    void readJSONFile(JSONObject jsonObject);
    void readCSVFile(List<MasterScadaCSVObject> csvObject);
}
