package com.lv.model;

/**
 * Created by simperLv
 * on 2018/08/06 17:13
 *
 * @Description //TODO
 */
public class User {
    private String name;
    private String passWord;

    public User(String name, String passWord){
        this.name = name;
        this.passWord = passWord;
    }
    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
