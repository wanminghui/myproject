package com.aba.ourvideo.Dao;


import com.aba.ourvideo.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Select("select * from t_user where uid=#{uid}")
    User GetUserInfo(Integer uid);


}
