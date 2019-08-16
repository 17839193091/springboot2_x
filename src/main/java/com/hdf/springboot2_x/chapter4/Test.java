package com.hdf.springboot2_x.chapter4;

import com.hdf.springboot2_x.chapter4.impl.HelloServiceImpl;
import com.hdf.springboot2_x.chapter4.intercept.MyInterceptor;
import com.hdf.springboot2_x.chapter4.proxy.ProxyBean;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 10:35
 */
public class Test {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("laozhang");
        System.out.println("name is null begin");
        proxy.sayHello(null);
    }
}
