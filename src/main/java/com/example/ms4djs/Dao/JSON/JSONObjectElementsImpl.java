package com.example.ms4djs.Dao.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JSONObjectElementsImpl implements JSONObjectElements {

    List<String> listPath = new ArrayList<>();
    String sessionId = "";

    @Autowired
    JSONPostReq jsonPostReq;

    @Override
    public String getSession(String user, String sessionId) {

        //String sessionId = "";
        String url = "http://127.0.0.1:8043/Methods/Login";
        String loginBody = "{\"sessionId\":\"" + sessionId + "\", " + "\"login\":" + user + "}";
        String keyJson = "sessionId";
        try {
            sessionId = jsonPostReq.getVarFromJSON(url, loginBody, keyJson,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sessionId = sessionId;
        return sessionId;
    }

    @Override
    public String getSessionId() {
        System.out.println(sessionId);
        return sessionId;
    }

    @Override
    public int getSubId(String sessionId) {

        String subId = "";
        String url = "http://127.0.0.1:8043/Methods/CreateDataSubscription";
        String sessionIdBody = "{\"sessionId\":" + sessionId + "}";
        String keyJson = "subscriptionId";
        try {
            subId = jsonPostReq.getVarFromJSON(url, sessionIdBody, keyJson, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("subId = " + subId);
        return Integer.parseInt(subId);
    }

    @Override
    public void setListPath(List<String> listPath) {
        this.listPath.addAll(listPath);
        System.out.println(this.listPath.get(0));
    }

    @Override
    public List<String> getListPath() {
        System.out.println(listPath.get(0));
        return listPath;
    }

    @Override
    public List<Integer> addMonitoredListItems(String sessionId, int subId, List<String> listPath) {
        System.out.println(sessionId + " " + subId + " " + listPath.get(0));
        String subIdt = "";
        String url = "http://127.0.0.1:8043/Methods/CreateMonitoredDataItems";
        String sessionBody = "{\"sessionId\":" + sessionId + ","
                + "\"subscriptionId\":" + subId + ","
                + "\"items\":["
                + "{\"clientHandle\":0," +
               // "\"itemId\":0," +
                "\"path\":\"" + listPath.get(0) + "\"}"
                + "]"
                + "}";
        String keyJson = "subscriptionId";
        System.out.println(sessionBody);
        try {
            subIdt = jsonPostReq.getVarFromJSON(url, sessionBody, keyJson, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("subIdt = " + subIdt);
        return null;
    }

    @Override
    public List<Integer> getListItems(String sessionId, int subId, int sequenceNumber) {
        System.out.println(sessionId + " " + subId + " " + sequenceNumber);
        String recs = "";
        String url = "http://127.0.0.1:8043/Methods/PublishData";
        String sessionBody = "{\"sessionId\":" + sessionId + ","
                + "\"subscriptionId\":" + subId// + ","
               // + "\"ackSequenceNumber\":" + sequenceNumber
                + "}";
        String keyJson = "recs";
        System.out.println(sessionBody);
        try {
            recs = jsonPostReq.getVarFromJSON(url, sessionBody, keyJson, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("recs = " + recs);
        return null;
    }
}
