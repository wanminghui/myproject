package com.aba.ourvideo.Controller;


import com.aba.ourvideo.Bean.User;
import com.aba.ourvideo.Service.UserService;
import com.aba.ourvideo.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     public boolean login(User user){
         System.out.println("传进入的值："+user);


        return false;
     }

}
