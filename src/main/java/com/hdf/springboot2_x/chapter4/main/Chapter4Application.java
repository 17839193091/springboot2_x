package com.hdf.springboot2_x.chapter4.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 14:58
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hdf.springboot2_x.chapter4.*"})
public class Chapter4Application {

    /*@Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Chapter4Application.class,args);
    }
}
