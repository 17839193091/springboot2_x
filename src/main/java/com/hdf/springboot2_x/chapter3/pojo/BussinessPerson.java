package com.hdf.springboot2_x.chapter3.pojo;

import com.hdf.springboot2_x.chapter3.pojo.definition.Animal;
import com.hdf.springboot2_x.chapter3.pojo.definition.Persion;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-11 20:37
 */
//@Component
public class BussinessPerson implements Persion, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private Animal animal = null;

    /*public BussinessPerson(@Autowired @Qualifier("dog") Animal animal) {
        this.animal = animal;
    }
    */
    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal animal) {
        //System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用BeanNameAware的setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用DisposableBean口的destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用InitializingBea口的afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("[" + this.getClass().getSimpleName() + "]调用ApplicationContextAware的setApplicationContext");
    }

    @PostConstruct
    public void init() {
        System.out.println("[" + this.getClass().getSimpleName() + "注解@PostConstruct定义的自定义初始化方法");
    }

    @PreDestroy
    public void destory1() {
        System.out.println("[" + this.getClass().getSimpleName() + "注解@PreDestroy定义的自定义销毁方法");
    }
}
