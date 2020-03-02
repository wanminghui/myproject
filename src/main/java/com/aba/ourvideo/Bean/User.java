package com.aba.ourvideo.Bean;

public class User {

    private Integer uid;
    private String uanme;
    private String upassword;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUanme() {
        return uanme;
    }

    public void setUanme(String uanme) {
        this.uanme = uanme;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uanme='" + uanme + '\'' +
                ", upassword='" + upassword + '\'' +
                '}';
    }

    public User(Integer uid, String uanme, String upassword) {//有参构造
        this.uid = uid;
        this.uanme = uanme;
        this.upassword = upassword;
    }

    public User() {
    }
}
