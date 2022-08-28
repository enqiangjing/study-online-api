package com.so.studyonline.service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class RedisStrService {

    private StringRedisTemplate redisTemplate;

    @Autowired
    public void setStringRedisTemPlate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 实现命令：TTL key，以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)。
     */
    public Long ttl(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 实现命令：expire 设置过期时间，单位秒
     */
    public Boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 实现命令：INCR key，增加key一次
     */
    public Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 实现命令：DEL key，删除一个key
     */
    public void del(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 实现命令：SET key value EX seconds，设置key-value和超时时间（秒）
     */
    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public void set5ks(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value, 5000, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现命令：GET key，返回 key所关联的字符串值。
     */
    public String get(String key) {
        String res = null;
        try {
            res = redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 实现命令：hSet key field value，将哈希表 key中的域 field的值设为 value
     */
    public void hSet(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 实现命令：hGet key field，返回哈希表 key中给定域 field的值
     */
    public String hGet(String key, String field) {
        return (String) redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 实现命令：hDel key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     */
    public void hDel(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 实现命令：hGetAll key，返回哈希表 key中，所有的域和值。
     */
    public Map<Object, Object> hGetAll(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 实现命令：lPush key value，将一个值 value插入到列表 key的表头
     */
    public Long lPush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 实现命令：lPop key，移除并返回列表 key的头元素。
     */
    public String lPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 实现命令：rPush key value，将一个值 value插入到列表 key的表尾(最右边)。
     */
    public Long rPush(String key, String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

}