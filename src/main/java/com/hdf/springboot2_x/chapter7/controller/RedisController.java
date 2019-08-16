package com.hdf.springboot2_x.chapter7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author hudongfei
 * @create 2019-08-14 15:45
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/hello")
    public void hello() {
        //两条命令是在不同的连接下执行的
        redisTemplate.opsForValue().set("key2", "value2");
        redisTemplate.opsForHash().put("hash", "field", "hvalue");
    }

    /**
     * 在同一条连接下执行多个Redis命令
     *
     * @param redisTemplate
     */
    public void useSessionCallback(RedisTemplate redisTemplate) {
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations ro) throws DataAccessException {
                ro.opsForValue().set("name", "laozhang");
                ro.opsForHash().put("map", "key", "value");
                return null;
            }
        });
    }

    @RequestMapping("/stringAndHash")
    public Map<String, Object> testStringAndHash() {
        redisTemplate.opsForValue().set("key1", "value1");
        //使用jdk序列化器，所以redis保存时不是整数，不能运算
        redisTemplate.opsForValue().set("int_key", "1");
        stringRedisTemplate.opsForValue().set("int", "1");
        //使用运算
        stringRedisTemplate.opsForValue().increment("int", 1);
        //获取底层jedis链接
        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        //减1操作，这个命令redisTemplate不支持，所以先获取底层链接再操作
        jedis.decr("int");
        Map<String, String> hash = new HashMap<>();
        hash.put("filed1", "value1");
        hash.put("filed2", "value2");
        //存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        //新增一个字段
        stringRedisTemplate.opsForHash().put("hash", "filed3", "value3");
        //绑定一个散列操作的key，这样可以连续的对同一个散列数据类型进行操作
        BoundHashOperations<String, Object, Object> hashOps = stringRedisTemplate.boundHashOps("hash");
        //删除两个字段
        hashOps.delete("filed1", "filed3");
        //新增一个字段
        hashOps.put("filed4", "value4");
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/testList")
    public Map<String, Object> testList() {

        //插入两个链表
        //链表从左到右顺序v10,v8,v6,v4,v2
        stringRedisTemplate.opsForList().leftPushAll("list1", "v2", "v4", "v6", "v8", "v10");
        //链表从左到右顺序v10,v8,v6,v4,v2
        stringRedisTemplate.opsForList().rightPushAll("list2", "v1", "v2", "v3", "v4", "v5", "v6");

        BoundListOperations<String, String> listOps = stringRedisTemplate.boundListOps("list2");
        //从右边弹出一个成员
        String result1 = listOps.rightPop();
        //获取定位元素，redis从0开始计算，这里值为v2
        String result2 = listOps.index(1);
        //从左边插入链表
        listOps.leftPush("v0");
        //求链表长度
        Long size = listOps.size();
        //求链表下标区间成员，整个链表下标范围0到size-1，这里不取最后一个元素
        List<String> elements = listOps.range(0, size - 2);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/testPipeline")
    public Map<String, Object> testPipeline() {
        Long start = System.currentTimeMillis();
        redisTemplate.executePipelined(new SessionCallback<String>() {
            @Override
            public String execute(RedisOperations operations) throws DataAccessException {
                for (int i = 1; i <= 100000; i++) {
                    operations.opsForValue().set("pipeline_" + i, "value_" + i);
                    String value = (String) operations.opsForValue().get("value_" + i);
                    if (i == 100000) {
                        System.out.println("命令只是进入队列，所以值为空");
                    }
                }
                return null;
            }
        });
        Long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "毫秒");

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @RequestMapping("/lua")
    public Map<String, Object> testLua() {
        DefaultRedisScript<String> rs = new DefaultRedisScript<>();
        //设置脚本
        rs.setScriptText("return 'hello redis'");
        //定义返回类型，注意如果没有这个定义，Spring不会返回结果
        rs.setResultType(String.class);
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        //执行lua脚本
        String str = (String) redisTemplate.execute(rs,stringSerializer,stringSerializer,null);

        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("str",str);
        return map;
    }
}
