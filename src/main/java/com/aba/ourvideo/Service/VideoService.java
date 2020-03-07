package com.aba.ourvideo.Service;

import com.aba.ourvideo.Bean.VideoInfo;
import com.aba.ourvideo.Bean.toPage;

import java.util.List;

public interface VideoService {
      List<VideoInfo> showVideoInfo(String content);

      Integer allcount(String name);

      List<VideoInfo>nextPage(toPage toPage);

}
