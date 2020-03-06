package com.aba.ourvideo.Controller;
import com.aba.ourvideo.Bean.User;
import com.aba.ourvideo.Bean.code;
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
        String msg="发送失败！,有可能你点击发送太快！或者一天只能接受5条短信～";
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
            if(response.getData().contains("OK")){

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

     //进行注册

    @PostMapping("user/register")
    @ResponseBody
    public  String register(@RequestBody phoneBean phoneBean) throws UnsupportedEncodingException {
        System.out.println("得到注册时候传入的信息："+phoneBean);
         String msg="注册失败，请检查您输入的信息是否有误";
        //1.进行格式校验
        if(phoneBean.getPhonenumber()==""||phoneBean.getT_code()==""||phoneBean.getUanme()==""||phoneBean.getUpassword()==""){
            System.out.println("输入值有为空的！");
           msg="您输入的值有误，请检查是否输入空的值！";
           return  msg;
        }else {
            //2.进行用户是否存在校验
          //根据用户uanme去查询是否存在此用户
         User user= userServiceImpl.SerchByUname(phoneBean.getUanme());
         if (user==null){//不存在此用户的时候
             //3.进行手机验证码校验
            code code=userServiceImpl.searchBycode(phoneBean.getT_code());
            if (code!=null&&code.getTelphone().equals(phoneBean.getPhonenumber())){
                //此时用户进行注册
                User loginuser=new User();
                loginuser.setUanme(phoneBean.getUanme());
                String upassword=phoneBean.getUpassword();
                Base64.Encoder encoder=Base64.getEncoder();
                byte[] bytes=upassword.getBytes("utf-8");
                String enUpassword= encoder.encodeToString(bytes);//得到编码后的密码数据
                loginuser.setUpassword(enUpassword);
                //进行注册！
             Integer registerNumber= userServiceImpl.register(loginuser);
                System.out.println("得到返回的结果数是："+registerNumber);
                     msg="注册成功！请登录~";
                     return msg;
             }else {//验证码不正确
                msg="你输入的验证码不正确请查看是否正确~";
                return  msg;
            }

         }else {//存在此用户！
             msg="存在此用户，请直接登录！";
             return  msg;
         }

        }

    }



}
