package com.aba.ourvideo.Controller;
import com.aba.ourvideo.Bean.User;
import com.aba.ourvideo.Bean.phoneBean;
import com.aba.ourvideo.ServiceImpl.UserServiceImpl;
import com.aba.ourvideo.utils.RegexUtil;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

     //发送短信验证码

    @PostMapping("user/sendcode")
    @ResponseBody
    public String SendMsg(@RequestBody phoneBean phoneBean){
        String msg="短信验证码发送失败";
        String number=phoneBean.getPhonenumber();
        RegexUtil regexUtil=new RegexUtil();
        //进行手机号格式校验
        boolean bool=number.matches(regexUtil.REGEX_MOBILE);
        System.out.println("查看匹配结果："+bool);
        if (!bool){
            msg="请检查手机号输入格式问题，或者是否输入有误！";
            return msg;
        }
        //如果手机号正确的话

        //密钥对
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FugBBDCGNiSn15VpQHD", "cyEbe929txRxPylKuAQE8n6P0ZiS4m");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        // request.setSysMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        // request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //需要接受短信的手机号！
        request.putQueryParameter("PhoneNumbers", number);
        //签名内容
        request.putQueryParameter("SignName", "v度课视频推荐平台");
        //短信模板
        request.putQueryParameter("TemplateCode", "SMS_184830996");
        //获取随机的6位短信验证码！
        int code= (int)(((Math.random()*9+1)*100000));
        String scode=String.valueOf(code);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+scode+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            System.out.println("短信发送成功！");
            //将验证码存储进数据库中
           Integer nu= userServiceImpl.insertTocode(number, scode);//存储成功
            if (nu!=0){
                msg="短信验证码发送成功！请注意查收！";
                return  msg;
            }else {
                msg="验证码存储进数据库有误请联系开发人员检查！";
                return msg;
            }

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return msg;
    }


     public User loginSearch( String uname){
         //根据账号查询此人信息
        return userServiceImpl.SerchByUname(uname);
     }



}
