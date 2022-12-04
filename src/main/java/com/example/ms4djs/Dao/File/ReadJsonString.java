package com.example.ms4djs.Dao.File;




import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ReadJsonString {

    //JSONObject jsonObject = new JSONObject();

    public JSONObject convertJsonString(String jsonString){
      //JSONObject jsonObject =
            return   new JSONObject(jsonString);
        //return jsonObject;
    }
}
