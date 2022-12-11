package com.example.ms4djs.Dao.File;

import com.example.ms4djs.model.MasterScadaCSVObject;
import com.opencsv.bean.CsvToBeanBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@Component
public class LoadFileImpl implements LoadFile {
    JSONObject jsonObject = new JSONObject();
    JSONParser parser = new JSONParser();

    //возвращает jsonObject через JsonParser, который считывает файл из pathFile
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
    public List<MasterScadaCSVObject> loadCSV(String pathFile) {
        List<MasterScadaCSVObject> masterScadaCSVObjectList = null;
        try {
            masterScadaCSVObjectList = new CsvToBeanBuilder(new FileReader(pathFile)).withType(MasterScadaCSVObject.class).withSeparator(';').build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return masterScadaCSVObjectList;
    }
}
