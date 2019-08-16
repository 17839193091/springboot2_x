package com.hdf.springboot2_x.chapter7.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-14 22:36
 */
@Alias("user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -6869716844753406188L;
    private Long id;
    private String userName;
    private String note;
}
