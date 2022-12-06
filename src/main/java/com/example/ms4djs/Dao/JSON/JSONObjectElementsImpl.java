package com.example.ms4djs.Dao.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class JSONObjectElementsImpl implements JSONObjectElements {

    @Autowired
    JSONPostReq jsonPostReq;

    @Override
    public String getSession(String user) {

        String sessionId = "";
        String url = "http://127.0.0.1:8043/Methods/Login";
        String loginBody = "{\"login\":" + user + "}";
        String keyJson = "sessionId";
        try {
            sessionId = jsonPostReq.getVarFromJSON(url, loginBody, keyJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionId;
    }

    @Override
    public String getSubId(String sessionId) {

        String subId = "";
        String url = "http://127.0.0.1:8043/Methods/CreateDataSubscription";
        String sessionIdBody = "{\"sessionId\":" + sessionId + "}";
        String keyJson = "subscriptionId";
        try {
            subId = jsonPostReq.getVarFromJSON(url, sessionIdBody, keyJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(subId);
        return subId;
    }

    @Override
    public List<Integer> listItems(int sessionId, int subId, List<Integer> listPath) {
        return null;
    }
}
