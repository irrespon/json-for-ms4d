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
    public String getSession(String user) {
        return jsonObjectElements.getSession(user);
    }

    @Override
    public String getSubId(String sessionId) {
        return jsonObjectElements.getSubId(sessionId);
    }

    @Override
    public List<Integer> listItems(int sessionId, int subId, List<Integer> listPath) {
        return jsonObjectElements.listItems(sessionId,subId,listPath);
    }
}
