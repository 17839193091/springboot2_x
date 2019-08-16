package com.hdf.springboot2_x.chapter4.impl;

import com.hdf.springboot2_x.chapter4.HelloService;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 10:14
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new RuntimeException("parameter is null");
        }
        System.out.println("hello " + name);
    }
}
