package com.example.ms4djs.Dao.JSON;

import com.example.ms4djs.util.ReadJsonString;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class JSONPostReq {

    @Autowired
    ReadJsonString readJsonString;

    String getVarFromJSON(String urlPost, String jsonInputString, String keyJson, boolean isArray) throws IOException {

        System.out.println(isArray);

        String valueJson = "";

        URL url = new URL(urlPost);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                System.out.println(responseLine);
                response.append(responseLine.trim());
            }
           //valueJson = String.valueOf(readJsonString.convertJsonString(response.toString()).get(keyJson));
            System.out.println("response = " + response);
            if(isArray) {
                System.out.println(jsonInputString);
                JSONObject js = new JSONObject(response.toString());
                System.out.println("Array = " + js.getJSONArray("recs").getJSONObject(0).get("value"));
            }
            valueJson = String.valueOf(new JSONObject(response.toString()).get(keyJson));
        }
        return valueJson;
    }
}
