package com.aba.ourvideo.Bean;

public class toPage {

    private String contextInfo;
    private  Integer currentPage;

    public String getContextInfo() {
        return contextInfo;
    }

    public void setContextInfo(String contextInfo) {
        this.contextInfo = contextInfo;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public toPage() {
    }

    @Override
    public String toString() {
        return "toPage{" +
                "contextInfo='" + contextInfo + '\'' +
                ", currentPage=" + currentPage +
                '}';
    }
}
