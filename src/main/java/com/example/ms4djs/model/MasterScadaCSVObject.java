package com.example.ms4djs.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvNumber;
import org.springframework.stereotype.Component;

@Component
public class MasterScadaCSVObject {
    @CsvBindByPosition(position = 0)
   // @CsvNumber("")
    private String elementId;
    @CsvBindByPosition(position = 1)
    private String displayName;
    @CsvBindByPosition(position = 2)
    private String fullName;
    @CsvBindByPosition(position = 3)
    private String elementType;

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }
}
