package com.hdf.springboot2_x.chapter5.service;

import com.hdf.springboot2_x.chapter5.pojo.User;

import java.util.List;

/**
 * 描述:
 *  测试事物传播行为
 * @author hudongfei
 * @create 2019-08-14 11:28
 */
public interface UserBatchService {
    int insertUsers(List<User> userList);
}
