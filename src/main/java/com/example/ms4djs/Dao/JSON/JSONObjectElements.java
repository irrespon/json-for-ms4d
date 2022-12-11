package com.example.ms4djs.Dao.JSON;

import java.util.List;

public interface JSONObjectElements {
    String getSession(String user, String sessionId);

    String getSessionId();

    int getSubId(String sessionId);

    void setListPath(List<String> listPath);

    List<String> getListPath();

    List<Integer> addMonitoredListItems(String sessionId, int subId, List<String> listPath);

    List<Integer> getListItems(String sessionId, int subId, int sequenceNumber);
}
