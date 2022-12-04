package com.example.ms4djs.service;

import java.util.List;

public interface ServiceGetJSON {
    int getSession(String user);

    int getSubId(int sessionId);

    List<Integer> listItems(int sessionId, int subId, List<Integer> listPath);
}
