package com.hdf.springboot2_x.chapter7.service.impl;

import com.hdf.springboot2_x.chapter7.dao.UserDao;
import com.hdf.springboot2_x.chapter7.pojo.User;
import com.hdf.springboot2_x.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    //先从缓存中通过定义的键查询，如果可以查询到数据，则返回，否则执行该方法，返回数据，并且将返回数据保存到缓存中
    @Cacheable(value = "redisCache", key = "'redis_user_' + #id")
    public User getUser(Long id) {
        return userDao.getUser(id);
    }


    @Override
    @Transactional
    //将方法结果返回存放到缓存中
    @CachePut(value = "redisCache", key = "'redis_user_'+ #result.id")
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }

    @Override
    @Transactional
    @CachePut(value = "redisCache", condition = "#result!='null'", key = "'redis_user_'+#id")
    public User updateUserName(Long id, String userName) {
        //此处调用getUser方法，该方法缓存注解失效，所以这里还是会执行SQL，将查询到数据库最新数据
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
    @CacheEvict(value = "redisCache", key = "'redis_user_' + #id")
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }
}
