package com.example.ms4djs.Dao.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class JSONObjectImpl implements JSONObjectElements {

    @Autowired
    JSONPostReq jsonPostReq;

    @Override
    public int getSession(String user) {

        int sessionId = 0;
        String url = "http://127.0.0.1:8043/Methods/Login";
        String login = "{\"login\":" + user + "}";
        try {
            jsonPostReq.getU(url,login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionId;
    }

    @Override
    public int getSubId(int sessionId) {
        return 0;
    }

    @Override
    public List<Integer> listItems(int sessionId, int subId, List<Integer> listPath) {
        return null;
    }
}
