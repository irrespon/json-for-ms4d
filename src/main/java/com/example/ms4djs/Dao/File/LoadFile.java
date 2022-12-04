package com.example.ms4djs.Dao.File;

import com.example.ms4djs.model.MasterScadaCSVObject;
import org.json.simple.JSONObject;

import java.util.List;

public interface LoadFile {
    JSONObject loadJSON(String pathFile);
    List<MasterScadaCSVObject> loadCSV(String pathFile);
}
