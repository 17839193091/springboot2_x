package com.hdf.springboot2_x.chapter5;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 14:58
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hdf.springboot2_x.chapter5.*"})
@MapperScan(basePackages = "com.hdf.springboot2_x.chapter5.dao",annotationClass = Repository.class)
public class Chapter5Application {

    /*@Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Chapter5Application.class,args);
    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    @PostConstruct
    public void view() {
        System.out.println(transactionManager.getClass().getName());
    }
}
