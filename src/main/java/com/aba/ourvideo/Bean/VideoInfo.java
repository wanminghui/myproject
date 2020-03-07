package com.aba.ourvideo.Bean;

public class VideoInfo {
    private int vid;
    private String addr;
    private  int t_id;
    private  String introduce;
    private boolean expire;

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public boolean isExpire() {
        return expire;
    }

    public void setExpire(boolean expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "vid=" + vid +
                ", addr='" + addr + '\'' +
                ", t_id=" + t_id +
                ", introduce='" + introduce + '\'' +
                ", expire=" + expire +
                '}';
    }

    public VideoInfo() {
    }
}
