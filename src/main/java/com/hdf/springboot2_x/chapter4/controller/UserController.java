package com.hdf.springboot2_x.chapter4.controller;

import com.hdf.springboot2_x.chapter4.UserService;
import com.hdf.springboot2_x.chapter4.aspect.validator.UserValidator;
import com.hdf.springboot2_x.chapter4.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 14:54
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(Long id,String userName,String note) {
        User user = new User(id,userName,note);
        userService.printUser(user);
        return user;
    }

    @RequestMapping("/vp")
    @ResponseBody
    public User validateAndPrint(Long id,String userName,String note) {
        User user = new User(id,userName,note);

        UserValidator userValidator = (UserValidator) userService;
        if (userValidator.validator(user)) {
            userService.printUser(user);
        }
        return user;
    }
}
