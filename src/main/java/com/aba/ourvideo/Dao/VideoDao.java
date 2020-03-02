package com.aba.ourvideo.Dao;

import com.aba.ourvideo.Bean.VideoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoDao {

     @Select("select * from t_video_info where introduce like '%${name}%'")//模糊查询用 %${传入的值}%
     List <VideoInfo> showVideoInfo(String name);//根据传入的值进行搜索查询

}
