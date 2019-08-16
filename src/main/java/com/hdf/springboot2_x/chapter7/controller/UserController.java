package com.hdf.springboot2_x.chapter7.controller;

import com.hdf.springboot2_x.chapter7.pojo.User;
import com.hdf.springboot2_x.chapter7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-14 23:12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    public User insertUser(String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);
        userService.insertUser(user);
        return user;
    }

    @RequestMapping("/findUsers")
    public List<User> findUsers(String userName, String note) {
        return userService.findUsers(userName, note);
    }

    @RequestMapping("/updateUserName")
    public Map<String, Object> updateUserName(Long id, String userName) {
        User user = userService.updateUserName(id, userName);
        boolean flag = user != null;
        String message = flag ? "成功" : "失败";
        Map<String,Object> map = new HashMap<>();
        map.put("success",flag);
        map.put("message",message);
        return map;
    }

    @RequestMapping("/deleteUser")
    public Map<String, Object> deleteUser(Long id) {
        int i = userService.deleteUser(id);
        boolean flag = i != 0;
        String message = flag ? "成功" : "失败";
        Map<String,Object> map = new HashMap<>();
        map.put("success",flag);
        map.put("message",message);
        return map;
    }
}
