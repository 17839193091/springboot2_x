package com.hdf.springboot2_x.chapter9;

import com.hdf.springboot2_x.chapter9.interceptor.Interceptor1;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 14:58
 */
@SpringBootApplication(scanBasePackages = "com.hdf.springboot2_x.chapter9.*")
@MapperScan(basePackages = "com.hdf.springboot2_x.chapter9.dao",annotationClass = Repository.class)
public class Chapter9Application implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(Chapter9Application.class,args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册到springmvc机制，然后返回一个拦截器注册
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new Interceptor1());
        //指定拦截匹配模式，限制拦截器拦截请求
        interceptorRegistration.addPathPatterns("/interceptor/*");
    }
}
