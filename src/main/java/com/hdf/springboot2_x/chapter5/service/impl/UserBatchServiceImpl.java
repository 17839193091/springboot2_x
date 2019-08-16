package com.hdf.springboot2_x.chapter5.service.impl;

import com.hdf.springboot2_x.chapter5.pojo.User;
import com.hdf.springboot2_x.chapter5.service.UserBatchService;
import com.hdf.springboot2_x.chapter5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-14 11:29
 */
@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    UserService userService;

    /**
     * REQUIRED 需要事物，他是默认的传播行为，如果当前存在事物，就沿用当前事物，否则新建一个事物运行子方法
     * @param userList
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        int count = 0;
        for (User user : userList) {
            count += userService.insertUser(user);
        }
        return count;
    }
}
