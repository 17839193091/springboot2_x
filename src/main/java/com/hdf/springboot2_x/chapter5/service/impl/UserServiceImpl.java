package com.hdf.springboot2_x.chapter5.service.impl;

import com.hdf.springboot2_x.chapter5.dao.MyBatisUserDao;
import com.hdf.springboot2_x.chapter5.pojo.User;
import com.hdf.springboot2_x.chapter5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 17:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    MyBatisUserDao myBatisUserDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED)
    public int insertUser(User user) {
        return myBatisUserDao.insertUser(user);
    }
}
