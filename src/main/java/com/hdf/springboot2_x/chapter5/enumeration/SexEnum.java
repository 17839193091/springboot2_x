package com.hdf.springboot2_x.chapter5.enumeration;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-13 13:28
 */
public enum  SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

    private int id;
    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SexEnum getEnumById(int id) {
        for (SexEnum sex : SexEnum.values()) {
            if (sex.getId() == id) {
                return sex;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
