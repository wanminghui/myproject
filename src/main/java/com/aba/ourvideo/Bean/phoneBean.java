package com.aba.ourvideo.Bean;

public class phoneBean {

   private String phonenumber;
   private String code;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "phoneBean{" +
                "phonenumber='" + phonenumber + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
