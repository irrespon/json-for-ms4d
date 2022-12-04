package com.example.ms4djs.Dao.JSON;

import java.util.List;

public interface JSONObjectElements {
    int getSession(String user);

    int getSubId(int sessionId);

    List<Integer> listItems(int sessionId, int subId, List<Integer> listPath);
}
