package com.hdf.springboot2_x.chapter3.config;

import com.hdf.springboot2_x.chapter3.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-11 19:42
 */

public class IocTest {
    private static Logger logger = LoggerFactory.getLogger(IocTest.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean("user", User.class);
        logger.info(user.toString());
    }
}
