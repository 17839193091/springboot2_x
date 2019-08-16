package com.hdf.springboot2_x.chapter4.aspect.validator.impl;

import com.hdf.springboot2_x.chapter4.aspect.validator.UserValidator;
import com.hdf.springboot2_x.chapter4.pojo.User;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 15:23
 */
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validator(User user) {
        System.out.println("引入新接口:" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
