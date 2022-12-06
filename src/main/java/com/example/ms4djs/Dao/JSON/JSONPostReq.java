package com.example.ms4djs.Dao.JSON;

import com.example.ms4djs.Dao.File.ReadJsonString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class JSONPostReq {

    @Autowired
    ReadJsonString readJsonString;

    String getVarFromJSON(String urlPost, String jsonInputString, String keyJson) throws IOException {

        String valueJson = "";

        URL url = new URL(urlPost);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
           valueJson = String.valueOf(readJsonString.convertJsonString(response.toString()).get(keyJson));
        }
        return valueJson;
    }
}
