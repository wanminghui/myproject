package com.aba.ourvideo.ServiceImpl;

import com.aba.ourvideo.Bean.User;
import com.aba.ourvideo.Dao.UserDao;
import com.aba.ourvideo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserInfo(Integer uid) {
        User user=userDao.GetUserInfo(uid);
        return user;
    }

    @Override
    public User SerchByUname(String uname) {

        return userDao.searchbyname(uname);
    }
}
