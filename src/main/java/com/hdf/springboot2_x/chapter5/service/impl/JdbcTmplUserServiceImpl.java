package com.hdf.springboot2_x.chapter5.service.impl;

import com.hdf.springboot2_x.chapter5.enumeration.SexEnum;
import com.hdf.springboot2_x.chapter5.pojo.User;
import com.hdf.springboot2_x.chapter5.service.JdbcTmplUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 15:43
 */

@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> getUserRowMapper() {
        RowMapper<User> userRowMapper = (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sex = rs.getInt("sex");
            SexEnum sexEnum = SexEnum.getEnumById(sex);
            user.setSex(sexEnum);
            user.setNote(rs.getString("note"));
            return user;
        };

        return userRowMapper;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public List<User> findUsers(String name, String note) {
        String sql = "select id,user_name,sex,note from t_user where user_name like concat('%',?,'%') and note like concat('%',?,'%')";
        Object[] params = new Object[] {name,note};
        List<User> userList = jdbcTemplate.query(sql, params, getUserRowMapper());
        return userList;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }
}
