package com.hdf.springboot2_x.chapter7.dao;

import com.hdf.springboot2_x.chapter7.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-14 22:49
 */
@Repository
public interface UserDao {

    User getUser(Long id);

    int insertUser(User user);

    int updateUser(User user);

    List<User> findUsers(@Param("userName") String userName,@Param("note") String note);

    int deleteUser(Long id);
}
