package com.example.ms4djs.model;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

//объект MasterScadaObject
@Component
public class MasterScadaObject {

    boolean AccessOPCUA;
    String Name;
    String TranslitedName;
    long ID;
    String Type;
    JSONArray Childs;

    public MasterScadaObject() {

    }

    public boolean isAccessOPCUA() {
        return AccessOPCUA;
    }

    public void setAccessOPCUA(boolean accessOPCUA) {
        AccessOPCUA = accessOPCUA;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTranslitedName() {
        return TranslitedName;
    }

    public void setTranslitedName(String translitedName) {
        TranslitedName = translitedName;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public JSONArray getChilds() {
        return Childs;
    }

    public void setChilds(JSONArray childs) {
        Childs = childs;
    }
}
