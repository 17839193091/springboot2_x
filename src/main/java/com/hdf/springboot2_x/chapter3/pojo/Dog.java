package com.hdf.springboot2_x.chapter3.pojo;

import com.hdf.springboot2_x.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-11 20:38
 */
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗 【"+ Dog.class.getSimpleName() + "】是看门用的 ");
    }
}
