package com.example.ms4djs.repository;

import com.example.ms4djs.model.MasterScadaJSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//возвращает объект masterScadaObject из JsonObject
@Component
public class JsonObjectToMasterScadaObject {

    @Autowired
    MasterScadaJSONObject masterScadaJSONObject;

    public MasterScadaJSONObject objJson(JSONObject obj) {

        masterScadaJSONObject.setAccessOPCUA((boolean) obj.get("AccessOPCUA"));
        masterScadaJSONObject.setName((String) obj.get("Name"));
        masterScadaJSONObject.setTranslitedName((String) obj.get("TranslitedName"));
        masterScadaJSONObject.setID((long) obj.get("ID"));
        masterScadaJSONObject.setType((String) obj.get("Type"));
        masterScadaJSONObject.setChilds((JSONArray) obj.get("Childs"));
        return masterScadaJSONObject;
    }
}
