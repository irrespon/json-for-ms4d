package com.example.ms4djs.Dao.File;

import com.example.ms4djs.model.MasterScadaCSVObject;
import org.json.simple.JSONObject;

import java.util.List;

public interface ReadFile {
    void readJSONFile(JSONObject jsonObject);
    List<String> readCSVFile(List<MasterScadaCSVObject> masterScadaCSVObjectList);
}
