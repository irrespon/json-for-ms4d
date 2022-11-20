package com.example.ms4djs.CRUDDao;

import com.example.ms4djs.model.MasterScadaObject;
import com.example.ms4djs.repository.JsonObjectToMasterScadaObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//распределяем объекты
@Component
public class ReadFileImpl implements ReadFile {

    @Autowired
    JsonObjectToMasterScadaObject jsonObjectToMasterScadaObject;

    @Override
    public void readJSONFile(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("projectTree");
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);

        JSONArray jsonArray1 = (JSONArray) jsonObject1.get("Childs");
        for (Object o: jsonArray1) {
            MasterScadaObject masterScadaObject = jsonObjectToMasterScadaObject.objJson((JSONObject) o);
            System.out.println("1 -> " + masterScadaObject.getName());
            JSONArray jsonArray2 = masterScadaObject.getChilds();
            System.out.println("1 -> length = " + jsonArray2.size());
            for (Object o1: jsonArray2) {
                MasterScadaObject masterScadaObject1 = jsonObjectToMasterScadaObject.objJson((JSONObject) o1);
                System.out.println("  2 -> " + masterScadaObject1.getName());
                JSONArray jsonArray3 = masterScadaObject1.getChilds();
                System.out.println("  2 -> length = " + jsonArray3.size());
            }
        }
    }

    @Override
    public void readCSVFile(String stringObject) {

    }
}
