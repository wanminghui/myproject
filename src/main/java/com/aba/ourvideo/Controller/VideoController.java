package com.aba.ourvideo.Controller;
import com.aba.ourvideo.Bean.VideoInfo;
import com.aba.ourvideo.Bean.toPage;
import com.aba.ourvideo.ServiceImpl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VideoController {

    @Autowired
    private VideoServiceImpl videoService;

//    @CrossOrigin(value = "http://localhost:8080" ,allowedHeaders = "*",maxAge = 1800)
    @PostMapping("/video/tosearch")
    @ResponseBody
    public List<VideoInfo> getVideoInfo(@RequestBody toPage toPage ){
        System.out.println("传入的值:"+toPage.getContextInfo());
        System.out.println("进入到查询所有视频信息的方法中来×××");
        List<VideoInfo>  infos= videoService.showVideoInfo(toPage.getContextInfo());
        return  infos;
    }

    @PostMapping("video/tonext")
    @ResponseBody
    public List<VideoInfo> getVideoInfoPage( @RequestBody toPage toPage){ //包含分页查询的方法中来
        /*包含的逻辑：分页展示输入当前的页码数
         每页包含的固定显示的数量为4条数据
         查询所有的条数，当当前页码数*4小于总共的数量的时候才能进行下一页的操作
        * */
        Integer allcount=videoService.allcount(toPage.getContextInfo());//所有的条数
        if (allcount==0){
            //查询出没有类似的时候
            return  null;
        }
        if (toPage.getCurrentPage()<=(allcount/4+1)){
            //当当前页码在理想的范围内的时候
            Integer Pagenumber=4*toPage.getCurrentPage()-4;//从第几条数据开始查起走
            System.out.println("得到从第几条数据开始查询的"+Pagenumber);
            toPage.setCurrentPage(Pagenumber);
            System.out.println("得到对象中的当前开始的查询数："+toPage.getCurrentPage());
          List<VideoInfo>  videoInfos= videoService.nextPage(toPage);
            System.out.println("得到分页查询出来的值是："+videoInfos);
               return videoInfos;
        }else {

            return  null;
        }

    }


}
