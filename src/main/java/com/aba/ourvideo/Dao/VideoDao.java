package com.aba.ourvideo.Dao;

import com.aba.ourvideo.Bean.VideoInfo;
import com.aba.ourvideo.Bean.toPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoDao {

     @Select("select * from t_video_info where introduce like '%${name}%' limit 0,4")//模糊查询用 %${传入的值}%
     List <VideoInfo> showVideoInfo(String name);//根据传入的值进行搜索查询

     @Select("select count(*) from t_video_info where introduce like '%${name}%'")
     Integer allCount(String name);

     //进行分页查询的操作
     @Select("select * from t_video_info where introduce like '%${contextInfo}%' limit #{currentPage},4")
     List<VideoInfo> nextPage (toPage toPage);



}
