package com.hdf.springboot2_x.chapter3.pojo;

import com.hdf.springboot2_x.chapter3.config.AppConfig;
import com.hdf.springboot2_x.other.pojo.Squirrel;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-11 20:41
 */
public class AnimalTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Squirrel squirrel = ctx.getBean(Squirrel.class);
        squirrel.use();
        ctx.close();
    }
}
