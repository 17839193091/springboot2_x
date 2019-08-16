package com.hdf.springboot2_x.chapter4.invoke;

import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 10:29
 */
@Data
public class Invocation {
    private Object[] params;

    private Method method;

    private Object target;

    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object proceed () throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,params);
    }
}
