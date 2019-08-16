package com.hdf.springboot2_x.chapter4.impl;

import com.hdf.springboot2_x.chapter4.UserService;
import com.hdf.springboot2_x.chapter4.pojo.User;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 11:16
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查用户参数为空");
        }
        System.out.println("id=" + user.getId());
        System.out.println("username=" + user.getUsername());
        System.out.println("note="+user.getNote());
    }
}
