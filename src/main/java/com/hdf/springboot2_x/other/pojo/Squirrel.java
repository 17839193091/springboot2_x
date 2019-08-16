package com.hdf.springboot2_x.other.pojo;

import com.hdf.springboot2_x.chapter3.pojo.definition.Animal;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 10:06
 */
public class Squirrel implements Animal {
    @Override
    public void use() {
        System.out.println("松鼠可以采松果");
    }
}
