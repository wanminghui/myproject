package com.aba.ourvideo.Controller;

import com.aba.ourvideo.utils.RegexUtil;

public class TestReg {


    public static void main(String[] args) {


        String phonenumber="18080812450";
         RegexUtil regexUtil =new RegexUtil();
         boolean bool= phonenumber.matches(regexUtil.REGEX_MOBILE);
        System.out.println("匹配结果是：+"+bool);





    }
}


