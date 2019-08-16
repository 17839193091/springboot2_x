package com.hdf.springboot2_x.chapter9.service.impl;

import com.hdf.springboot2_x.chapter9.dao.UserDao;
import com.hdf.springboot2_x.chapter9.pojo.User;
import com.hdf.springboot2_x.chapter9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-14 22:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDao.getUser(id);
    }


    @Override
    @Transactional
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    @Override
    @Transactional
    public User updateUserName(Long id, String userName) {
        User user = this.getUser(id);
        if (user == null) {
            return null;
        }
        user.setUserName(userName);
        userDao.updateUser(user);
        return user;
    }

    //命中率低，不采用缓存机制
    @Override
    public List<User> findUsers(String userName, String note) {
        return userDao.findUsers(userName, note);
    }

    //移除缓存
    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
