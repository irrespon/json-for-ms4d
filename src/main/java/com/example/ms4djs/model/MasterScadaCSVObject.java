package com.example.ms4djs.model;

import com.opencsv.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MasterScadaCSVObject {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CsvBindByName(column = "Property~Id элемента~Id")
   // @CsvNumber("")
    private String elementId;

    @CsvBindByName(column = "Property~Имя~DisplayName")
    private String displayName;

//    @CsvBindAndSplitByName(column = "Property~Полное имя~FullName", splitOn = "\\.", collectionType = List.class, elementType = String.class)
//    private List<String> fullName;

    @CsvBindByName(column = "Property~Полное имя~FullName")
    private String fullName2;

    @CsvBindByName(column = "Property~Классификация~ItemTypeDisplayName")
    private String elementType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

//    public List<String> getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(List<String> fullName) {
//        this.fullName = fullName;
//    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getFullName2() {
        return fullName2;
    }

    public void setFullName2(String fullName2) {
        this.fullName2 = fullName2;
    }
}
