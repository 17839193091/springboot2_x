package com.hdf.springboot2_x.chapter5.service;

import com.hdf.springboot2_x.chapter5.pojo.User;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 17:33
 */
public interface UserService {
    User getUser(Long id);
    int insertUser(User user);
}
