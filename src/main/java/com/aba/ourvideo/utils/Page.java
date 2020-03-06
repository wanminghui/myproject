package com.aba.ourvideo.utils;

/*
* AUTHOR By wanminghui
* */
public class Page {
    //分页自助类

    private  static Integer currentPage;//当前页码数
    private static Integer showTotal;//在一页中展示的条数
    private  static Integer allTotal;//所有的条数

    public static Integer getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(Integer currentPage) {
        Page.currentPage = currentPage;
    }

    public static Integer getShowTotal() {
        return showTotal;
    }

    public static void setShowTotal(Integer showTotal) {
        Page.showTotal = showTotal;
    }

    public static Integer getAllTotal() {
        return allTotal;
    }

    public static void setAllTotal(Integer allTotal) {
        Page.allTotal = allTotal;
    }


}
