package com.hdf.springboot2_x.chapter5.service;

import com.hdf.springboot2_x.chapter5.pojo.User;

import java.util.List;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 15:38
 */
public interface JdbcTmplUserService {

    User getUser(Long id);

    List<User> findUsers(String name,String note);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);
}
