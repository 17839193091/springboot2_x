package com.hdf.springboot2_x.chapter4.aspect;

import com.hdf.springboot2_x.chapter4.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 14:31
 */
@Aspect
@Component
public class MyAspect {

//    @DeclareParents(value = "com.hdf.springboot2_x.chapter4.impl.UserServiceImpl+",defaultImpl = UserValidatorImpl.class)
//    public UserValidator userValidator;

    @Pointcut("execution(* com.hdf.springboot2_x.chapter4.impl.UserServiceImpl.printUser(..))")
    public void myPointCut() {}

    @Before("myPointCut()")
    public void before() {
        System.out.println("before");
    }

    @Before("myPointCut()&&args(user)")
    public void beforeParam(JoinPoint jp, User user) {
        Object[] args = jp.getArgs();
        System.out.println("before....");
    }

    @After("myPointCut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("myPointCut()")
    public void afterReturning() {
        System.out.println("after returning");
    }

    @AfterThrowing("myPointCut()")
    public void afterThrowing() {
        System.out.println("after throwing");
    }

    @Around("myPointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before");
        jp.proceed();
        System.out.println("around after");
    }

}
