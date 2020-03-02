package com.aba.ourvideo.Controller;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

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



    }
}
