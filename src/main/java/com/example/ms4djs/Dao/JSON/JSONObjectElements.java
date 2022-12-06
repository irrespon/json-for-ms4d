package com.example.ms4djs.Dao.JSON;

import java.util.List;

public interface JSONObjectElements {
    String getSession(String user);

    String getSubId(String sessionId);

    List<Integer> listItems(int sessionId, int subId, List<Integer> listPath);
}
