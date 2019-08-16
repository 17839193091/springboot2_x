package com.hdf.springboot2_x.chapter4.intercept;

import com.hdf.springboot2_x.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 10:31
 */
public class MyInterceptor implements Intercepter {
    @Override
    public boolean before() {
        System.out.println("before.........");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after.........");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before.......");
        Object obj = invocation.proceed();
        System.out.println("around after.......");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning.......");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing.......");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
