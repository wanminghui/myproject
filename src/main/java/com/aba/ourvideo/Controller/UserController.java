package com.aba.ourvideo.Controller;
import com.aba.ourvideo.Bean.User;
import com.aba.ourvideo.Service.UserService;
import com.aba.ourvideo.ServiceImpl.UserServiceImpl;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "/user/{uid}",produces = "application/json;charset=utf-8")
    @ResponseBody
     public User GetUserInfo(@PathVariable Integer uid){
        System.out.println("进入到展个人信息的方法中来");
          User user= userServiceImpl.getUserInfo(uid);
         return  user;
     }

     @PostMapping("/user/login")
     @ResponseBody
     public boolean login(@RequestBody User user) throws UnsupportedEncodingException {
        boolean result=false;
        System.out.println("传进入的值："+user);
        String uname=user.getUanme();
        String upassword=user.getUpassword();
         Base64.Encoder encoder=Base64.getEncoder();
         byte[] bytes=upassword.getBytes("utf-8");
         String enUpassword= encoder.encodeToString(bytes);//得到编码后的密码数据
         User suser= loginSearch(uname);
          if (suser!=null){
           if(suser.getUpassword().equals(enUpassword)){
               result=true;
               return  result;
           }

          }
        return false;
     }

     public User loginSearch( String uname){
         //根据账号查询此人信息
        return userServiceImpl.SerchByUname(uname);
     }



}
