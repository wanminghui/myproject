package com.aba.ourvideo.Controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class sendMsg {

        public static void main(String[] args) {
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
            request.putQueryParameter("PhoneNumbers", "15198073672");
            //签名内容
            request.putQueryParameter("SignName", "v度课视频推荐平台");
            //短信模板
            request.putQueryParameter("TemplateCode", "SMS_184830996");
            String scode="2235";
            request.putQueryParameter("TemplateParam", "{\"code\":\""+scode+"\"}");
            try {
                CommonResponse response = client.getCommonResponse(request);
                System.out.println(response.getData());
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }

    }
}
