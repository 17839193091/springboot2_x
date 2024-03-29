package com.hdf.springboot2_x.chapter5.controller;

import com.hdf.springboot2_x.chapter5.pojo.User;
import com.hdf.springboot2_x.chapter5.service.UserBatchService;
import com.hdf.springboot2_x.chapter5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 17:49
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserBatchService userBatchService;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public Map<String,Object> insertUser(String userName,String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);
        int update = userService.insertUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("success",update ==1);
        result.put("user",user);
        return result;
    }

    @RequestMapping("/insertUsers")
    @ResponseBody
    public Map<String,Object> insertUsers(String userName1,String note1,String userName2,String note2) {
        User user1 = new User();
        user1.setUserName(userName1);
        user1.setNote(note1);
        User user2 = new User();
        user2.setUserName(userName2);
        user2.setNote(note2);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        int inserts = userBatchService.insertUsers(userList);
        Map<String,Object> result = new HashMap<>();
        result.put("success",inserts>0);
        result.put("user",userList);
        return result;
    }
}
