package com.hdf.springboot2_x.chapter3.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 9:41
 */
@Component
@Data
//@ConfigurationProperties("database")
public class DataBaseProperties {
    @Value("${database.driverName}")
    private String driverName = null;
    @Value("${database.url}")
    private String url = null;
    @Value("${database.username}")
    private String username = null;
    @Value("${database.password}")
    private String password = null;
    @Value("#{T(System).currentTimeMillis()}")
    private Long initTime = null;
}
