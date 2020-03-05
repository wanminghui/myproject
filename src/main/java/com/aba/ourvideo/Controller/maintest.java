package com.aba.ourvideo.Controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Random;

//进行base64的编码解码！
public class maintest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String password="wan123456";
        String dpass="";
        Base64.Encoder encoder=Base64.getEncoder();
        byte[] bytes1=password.getBytes("utf-8");
        String entext = encoder.encodeToString(bytes1);
        System.out.println("这是编码后的string文本"+":"+entext);
        Base64.Decoder decoder=Base64.getDecoder();
        dpass=new String(decoder.decode(entext),"UTF-8");
        System.out.println("解码后的:"+dpass);

        //获取6位随机验证码
        int code= (int)(((Math.random()*9+1)*100000));

        System.out.println( "得到的数字结果是："+ code);






    }
}
