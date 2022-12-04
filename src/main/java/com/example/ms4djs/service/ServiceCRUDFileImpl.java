package com.example.ms4djs.service;

import com.example.ms4djs.Dao.File.LoadFile;
import com.example.ms4djs.Dao.File.ReadFile;
import com.example.ms4djs.Dao.File.SaveFile;
import com.example.ms4djs.model.MasterScadaCSVObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ServiceCRUDFileImpl implements ServiceCRUDFile {

    @Autowired
    private SaveFile saveFile;

    @Autowired
    private LoadFile loadFile;

    @Autowired
    private ReadFile readFile;

    @Override
    public boolean save(MultipartFile file) {
        return saveFile.save(file);
    }

    @Override
    public JSONObject loadJSON(String pathFile) {
        return loadFile.loadJSON(pathFile);
    }

    @Override
    public List<MasterScadaCSVObject> loadCSV(String pathFile) {
        return loadFile.loadCSV(pathFile);
    }

    @Override
    public void readJSONFile(JSONObject jsonObject) {
        readFile.readJSONFile(jsonObject);
    }

    @Override
    public void readCSVFile(List<MasterScadaCSVObject> csvObject) {
        readFile.readCSVFile(csvObject);
    }
}
