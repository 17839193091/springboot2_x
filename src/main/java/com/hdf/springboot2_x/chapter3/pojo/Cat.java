package com.hdf.springboot2_x.chapter3.pojo;

import com.hdf.springboot2_x.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-11 20:43
 */
@Component
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫 【"+ Dog.class.getSimpleName() + "】是抓老鼠用的 ");
    }
}
