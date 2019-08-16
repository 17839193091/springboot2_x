package com.hdf.springboot2_x.chapter5.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 17:31
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

    private ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = this.applicationContext.getBean(DataSource.class);
        System.out.println("----------------"+dataSource.getClass().getName() + "---------------");
    }
}
