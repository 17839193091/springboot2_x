package com.hdf.springboot2_x.chapter7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 14:58
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hdf.springboot2_x.chapter7.*"})
@EnableCaching
@MapperScan(basePackages = "com.hdf.springboot2_x.chapter7.dao",annotationClass = Repository.class)
public class Chapter7Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter7Application.class,args);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private MessageListener redisMessageListener;

    //任务池
    private ThreadPoolTaskScheduler taskScheduler;

    /**
     * 创建任务池，运行线程等待处理redis消息
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler() {
        if (taskScheduler != null) {
            return taskScheduler;
        }

        taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    /**
     * 定义redis监听容器
     * @return
     */
    @Bean
    public RedisMessageListenerContainer initRedisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(initTaskScheduler());
        Topic topic = new ChannelTopic("topic1");
        //使用监听器监听redis消息
        container.addMessageListener(redisMessageListener,topic);
        return container;
    }

}
