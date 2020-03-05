package com.aba.ourvideo.Bean;

public class phoneBean {


   private String phonenumber;
   private String t_code;
   private String uanme;
   private String upassword;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getT_code() {
        return t_code;
    }

    public void setT_code(String t_code) {
        this.t_code = t_code;
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
        return "phoneBean{" +
                "phonenumber='" + phonenumber + '\'' +
                ", t_code='" + t_code + '\'' +
                ", uanme='" + uanme + '\'' +
                ", upassword='" + upassword + '\'' +
                '}';
    }

    public phoneBean(String phonenumber, String t_code, String uanme, String upassword) {
        this.phonenumber = phonenumber;
        this.t_code = t_code;
        this.uanme = uanme;
        this.upassword = upassword;
    }

    public phoneBean() {
    }
}
