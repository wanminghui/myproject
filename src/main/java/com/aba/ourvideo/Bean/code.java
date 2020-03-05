package com.aba.ourvideo.Bean;

public class code {

   private Integer cid;
   private  String telphone;
   private  String t_code;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getT_code() {
        return t_code;
    }

    public void setT_code(String t_code) {
        this.t_code = t_code;
    }

    @Override
    public String toString() {
        return "code{" +
                "cid=" + cid +
                ", telphone='" + telphone + '\'' +
                ", t_code='" + t_code + '\'' +
                '}';
    }
}
