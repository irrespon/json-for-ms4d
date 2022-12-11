package com.example.ms4djs.service;

import java.util.List;

public interface ServiceGetJSON {
    String getSession(String user, String sessionId);

    String getSessionId();

    int getSubId(String sessionId);

    List<Integer> addMonitoredListItems(String sessionId, int subId, List<String> listPath);

    void setListPath(List<String> listPath);

    List<String> getListPath();

    List<Integer> getListItems(String sessionId, int subId, int ackSequenceNumber);
}
