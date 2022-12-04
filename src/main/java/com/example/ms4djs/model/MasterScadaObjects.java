package com.example.ms4djs.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Scope("prototype")
public class MasterScadaObjects {

    private Long id;

    private String object1;
    private String object2;
    private String object3;
    private String object4;
    private String object5;
    private String object6;
    private String object7;
    private String object8;
    private String object9;
    private String object10;

    private List<String> objList;
    private String[] objArray = new String[] {object1,object2,object3,object4,object5,object6,object7,object8,object9,object10};

    private MasterScadaObjects(){

    }

    public List<String> getObjList(){
        return objList;
    }

    public void setObjList(List<String> objList){

        String a = "";
        for(int i = 0;i < objList.size();i ++){
            objArray[i] = objList.get(i);
            a = a.concat(objArray[i]).concat("/");
        }
        System.out.println(a);

    }

    public String getObject1() {
        return object1;
    }

    public void setObject1(String object1) {
        this.object1 = object1;
    }

    public String getObject2() {
        return object2;
    }

    public void setObject2(String object2) {
        this.object2 = object2;
    }

    public String getObject3() {
        return object3;
    }

    public void setObject3(String object3) {
        this.object3 = object3;
    }

    public String getObject4() {
        return object4;
    }

    public void setObject4(String object4) {
        this.object4 = object4;
    }

    public String getObject5() {
        return object5;
    }

    public void setObject5(String object5) {
        this.object5 = object5;
    }

    public String getObject6() {
        return object6;
    }

    public void setObject6(String object6) {
        this.object6 = object6;
    }

    public String getObject7() {
        return object7;
    }

    public void setObject7(String object7) {
        this.object7 = object7;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
