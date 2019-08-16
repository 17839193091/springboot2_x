package com.hdf.springboot2_x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@ComponentScan(basePackages = {"com.hdf.springboot2_x.chapter3.*"})
@PropertySource(value = "classpath:jdbc.properties",ignoreResourceNotFound = true)
public class Springboot2XApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2XApplication.class, args);
    }

}
