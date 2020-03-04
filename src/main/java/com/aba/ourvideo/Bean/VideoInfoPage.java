package com.aba.ourvideo.Bean;

public class VideoInfoPage {
    private int vid;
    private String addr;
    private  int t_id;
    private  String introduce;
    private  int currentPage;
    private  int totolPage;

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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotolPage() {
        return totolPage;
    }

    public void setTotolPage(int totolPage) {
        this.totolPage = totolPage;
    }

    @Override
    public String toString() {
        return "VideoInfoPage{" +
                "vid=" + vid +
                ", addr='" + addr + '\'' +
                ", t_id=" + t_id +
                ", introduce='" + introduce + '\'' +
                ", currentPage=" + currentPage +
                ", totolPage=" + totolPage +
                '}';
    }
}
