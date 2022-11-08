package com.example.ms4djs.repository;

import com.example.ms4djs.model.MasterScadaObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class JsonObjectToMasterScadaObject {

    @Autowired
    MasterScadaObject masterScadaObject;

    MasterScadaObject objJson(JSONObject obj) {

        masterScadaObject.setAccessOPCUA((boolean) obj.get("AccessOPCUA"));
        masterScadaObject.setName((String) obj.get("Name"));
        masterScadaObject.setTranslitedName((String) obj.get("TranslitedName"));
        masterScadaObject.setID((long) obj.get("ID"));
        masterScadaObject.setType((String) obj.get("Type"));
        masterScadaObject.setChilds((JSONArray) obj.get("Childs"));
        return masterScadaObject;
    }
}
