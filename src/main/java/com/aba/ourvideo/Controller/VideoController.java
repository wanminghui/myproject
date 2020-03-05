package com.aba.ourvideo.Controller;
import com.aba.ourvideo.Bean.VideoInfo;
import com.aba.ourvideo.ServiceImpl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VideoController {

    @Autowired
    private VideoServiceImpl videoService;

    @GetMapping(value = "/video/{content}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<VideoInfo> getVideoInfo(@PathVariable String content){
        System.out.println("传入的值:"+content);
        System.out.println("进入到查询所有视频信息的方法中来×××");
        List<VideoInfo>  infos= videoService.showVideoInfo(content);
        return  infos;
    }





    public List<VideoInfo> getVideoInfoPage(){ //包含分页查询的方法中来


        return  null;
    }


}
