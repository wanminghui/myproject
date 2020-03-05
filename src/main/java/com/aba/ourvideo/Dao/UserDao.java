package com.aba.ourvideo.Dao;


import com.aba.ourvideo.Bean.User;
import com.aba.ourvideo.Bean.phoneBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    @Select("select * from t_user where uid=#{uid}")
    User GetUserInfo(Integer uid);

    @Select("select * from t_user where uanme=#{uname}")
    User searchbyname(String uname);

    @Insert("insert into t_code(telphone,t_code)values(#{phonenumber},#{code})")
    Integer insertCode(String phonenumber,String code);

}
