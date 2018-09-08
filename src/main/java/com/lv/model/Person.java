package com.lv.model;

/**
 * Created by simperLv
 * on 2018/07/30 16:32
 */
public class Person {
    private String name;
    private int age;

    public Person(){

    }
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getInfo(){
        return name + "(" + age + ")";
    }
}
