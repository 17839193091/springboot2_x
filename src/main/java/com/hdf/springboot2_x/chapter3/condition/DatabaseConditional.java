package com.hdf.springboot2_x.chapter3.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-12 9:50
 */
public class DatabaseConditional implements Condition {
    /**
     * 数据库装配条件
     * @param context 条件上下文
     * @param metadata 注释类型的元数据
     * @return true 装配bean，否则不装配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //取出环境
        Environment env = context.getEnvironment();
        //判断属性文件是否存在对应的数据库配置
        return env.containsProperty("database.driverName")&&env.containsProperty("database.url")&&env.containsProperty("database.username")&&env.containsProperty("database.password");
    }
}
