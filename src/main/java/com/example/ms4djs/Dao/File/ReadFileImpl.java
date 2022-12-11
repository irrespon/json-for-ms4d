package com.example.ms4djs.Dao.File;

import com.example.ms4djs.model.MasterScadaCSVObject;
import com.example.ms4djs.model.MasterScadaJSONObject;
import com.example.ms4djs.model.MasterScadaObjects;
import com.example.ms4djs.util.JsonObjectToMasterScadaObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//распределяем объекты
@Component
public class ReadFileImpl implements ReadFile {

    @Autowired
    JsonObjectToMasterScadaObject jsonObjectToMasterScadaObject;

    @Autowired
    MasterScadaCSVObject masterScadaCSVObject;

    @Autowired
    MasterScadaObjects masterScadaObjects;

    @Override
    public void readJSONFile(JSONObject jsonObject) {
        JSONArray jsonArray = (JSONArray) jsonObject.get("projectTree");
        JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);

        JSONArray jsonArray1 = (JSONArray) jsonObject1.get("Childs");
        for (Object o: jsonArray1) {
            MasterScadaJSONObject masterScadaJSONObject = jsonObjectToMasterScadaObject.objJson((JSONObject) o);
            System.out.println("1 -> " + masterScadaJSONObject.getName());
            JSONArray jsonArray2 = masterScadaJSONObject.getChilds();
            System.out.println("1 -> length = " + jsonArray2.size());
            for (Object o1: jsonArray2) {
                MasterScadaJSONObject masterScadaJSONObject1 = jsonObjectToMasterScadaObject.objJson((JSONObject) o1);
                System.out.println("  2 -> " + masterScadaJSONObject1.getName());
                JSONArray jsonArray3 = masterScadaJSONObject1.getChilds();
                System.out.println("  2 -> length = " + jsonArray3.size());
            }
        }
    }

    @Override
    public List<String> readCSVFile(List<MasterScadaCSVObject> masterScadaCSVObjectList) {
        List<String> listFullName2 = new ArrayList<>();
//        Predicate<MasterScadaCSVObject> masterScadaCSVObjectPredicate1 = s -> s.getDisplayName().contains("Параметр");
//        Predicate<MasterScadaCSVObject> masterScadaCSVObjectPredicate2 = s -> s.getDisplayName().contains("Вход");
//       masterScadaCSVObjectList.stream()
//               //.filter(masterScadaCSVObjectPredicate1.or(masterScadaCSVObjectPredicate2))
//               .forEach(s-> s.getFullName().stream().forEach(a-> System.out.println(a)));
        for(MasterScadaCSVObject masterScadaCSVObject:masterScadaCSVObjectList){
            listFullName2.add(masterScadaCSVObject.getFullName2());
            //System.out.println(masterScadaCSVObject.getFullName2());
           // masterScadaObjects.setObjList(masterScadaCSVObject.getFullName());

        }
        return listFullName2;
    }
}
