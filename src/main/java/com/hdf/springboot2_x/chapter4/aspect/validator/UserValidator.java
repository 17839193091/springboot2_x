package com.hdf.springboot2_x.chapter4.aspect.validator;

import com.hdf.springboot2_x.chapter4.pojo.User;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 15:22
 */
public interface UserValidator {
    public boolean validator(User user);
}
