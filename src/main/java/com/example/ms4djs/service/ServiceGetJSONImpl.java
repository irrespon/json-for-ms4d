package com.example.ms4djs.service;

import com.example.ms4djs.Dao.JSON.JSONObjectElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceGetJSONImpl implements ServiceGetJSON{

    @Autowired
    JSONObjectElements jsonObjectElements;

    @Override
    public String getSession(String user, String sessionId) {
        return jsonObjectElements.getSession(user, sessionId);
    }

    @Override
    public String getSessionId(){
        return jsonObjectElements.getSessionId();
    }

    @Override
    public int getSubId(String sessionId) {
        return jsonObjectElements.getSubId(sessionId);
    }

    @Override
    public List<Integer> addMonitoredListItems(String sessionId, int subId, List<String> listPath) {
        return jsonObjectElements.addMonitoredListItems(sessionId,subId,listPath);
    }

    @Override
    public void setListPath(List<String> listPath) {
        jsonObjectElements.setListPath(listPath);
    }

    @Override
    public List<String> getListPath() {
        return jsonObjectElements.getListPath();
    }

    @Override
    public List<Integer> getListItems(String sessionId, int subId, int ackSequenceNumber) {
        return jsonObjectElements.getListItems(sessionId, subId, ackSequenceNumber);
    }
}
