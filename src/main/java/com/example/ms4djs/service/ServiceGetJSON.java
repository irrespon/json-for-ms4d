package com.example.ms4djs.service;

import java.util.List;

public interface ServiceGetJSON {
    String getSession(String user);

    String getSubId(String sessionId);

    List<Integer> listItems(int sessionId, int subId, List<Integer> listPath);
}
