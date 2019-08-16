package com.hdf.springboot2_x.chapter4.intercept;

import com.hdf.springboot2_x.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 10:17
 */
public interface Intercepter {

    /**
     * 事前方法
     * @return
     */
    boolean before();

    /**
     * 事后方法
     * @return
     */
    void after();

    /**
     * 取代原有事件方法
     * @param invocation --回调方法，可以通过它的proceed方法回调原有事件
     * @return  原事件返回对象
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

    /**
     * 是否返回方法，事件没有发生异常执行
     */
    void afterReturning();

    /**
     * 事后异常方法，当事件发生异常后执行
     */
    void afterThrowing();

    /**
     * 是否使用around方法取代原来方法
     * @return
     */
    boolean useAround();
}
