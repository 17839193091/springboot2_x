package com.hdf.springboot2_x.chapter9.service;

import com.hdf.springboot2_x.chapter9.pojo.User;

import java.util.List;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-14 22:57
 */
public interface UserService {
    User getUser(Long id);

    User insertUser(User user);

    User updateUserName(Long id, String userName);

    List<User> findUsers(String userName, String note);

    int deleteUser(Long id);
}
