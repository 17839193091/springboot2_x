package com.hdf.springboot2_x.chapter8.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-15 16:47
 */
@Document
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -7509974588612734091L;

    private Long id;

    @Field("role_name")
    private String roleName;

    private String note;
}
