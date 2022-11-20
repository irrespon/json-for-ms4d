package com.example.ms4djs.service;

import com.example.ms4djs.CRUDDao.LoadFile;
import com.example.ms4djs.CRUDDao.ReadFile;
import com.example.ms4djs.CRUDDao.SaveFile;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public String loadString(String pathFile) {
        return null;
    }

    @Override
    public void readJSONFile(JSONObject jsonObject) {
        readFile.readJSONFile(jsonObject);
    }

    @Override
    public void readStringFile(String stringObject) {

    }
}
