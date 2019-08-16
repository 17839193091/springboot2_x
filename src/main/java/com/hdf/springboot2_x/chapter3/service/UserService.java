package com.hdf.springboot2_x.chapter3.service;

import com.hdf.springboot2_x.chapter3.pojo.User;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-11 19:52
 */
@Service
public class UserService {

    public void printUser(User user) {
        System.out.println("编号:" + user.getId());
        System.out.println("用户名称:" + user.getUserName());
        System.out.println("备注:" + user.getNote());
    }
}
