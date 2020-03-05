package com.aba.ourvideo.Service;

import com.aba.ourvideo.Bean.User;
import com.aba.ourvideo.Bean.code;

public interface UserService {

  User getUserInfo(Integer uid);
  User SerchByUname(String uname);//通过用户姓名查询是否存在
  Integer insertTocode(String phonenumber,String code);
  code searchBycode (String code);//通过用户输入的验证码查询此用户的信息
  Integer register(User user);

}
