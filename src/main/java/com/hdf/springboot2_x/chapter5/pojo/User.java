package com.hdf.springboot2_x.chapter5.pojo;

import com.hdf.springboot2_x.chapter5.enumeration.SexEnum;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 13:26
 */
@Data
//mybatis指定别名
@Alias(value = "user")
public class User {
    private Long id;
    private String userName;
    private SexEnum sex;
    private String note;
}
