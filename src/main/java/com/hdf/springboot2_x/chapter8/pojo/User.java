package com.hdf.springboot2_x.chapter8.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-15 16:42
 */
@Document
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1283359979019757510L;

    @Id
    private Long id;

    @Field("user_name")
    private String userName;

    private String note;
}
