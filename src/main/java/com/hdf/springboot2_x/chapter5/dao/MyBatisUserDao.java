package com.hdf.springboot2_x.chapter5.dao;

import com.hdf.springboot2_x.chapter5.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 16:13
 */
@Repository
public interface MyBatisUserDao {

    User getUser(Long id);

    int insertUser(User user);
}
