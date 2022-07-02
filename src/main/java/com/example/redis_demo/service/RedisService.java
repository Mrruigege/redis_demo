package com.example.redis_demo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author dengR
 * @date 2022/4/27 20:31
 */
public interface RedisService {

        /**
         * 指定缓存失效时间
         *
         * @param key  键
         * @param time 时间(秒)
         * @return 是否成功
         */
        Boolean expire(String key, Long time);

        Boolean expire(String key, Long time, TimeUnit timeUnit);

        /**
         * @param key 键 不能为null
         * @return 时间(秒) 返回0代表为永久有效
         */
        Long getExpire(String key);

        /**
         * 判断key是否存在
         *
         * @param key 键
         * @return true 存在 false不存在
         */
        Boolean hasKey(String key);

        /**
         * 删除缓存
         *
         * @param key 可以传一个值 或多个
         */
        void del(String... key);

        /**
         * 普通缓存获取
         *
         * @param key 键
         * @return 值
         */
        Object get(String key);

        /**
         * 普通缓存放入
         *
         * @param key   键
         * @param value 值
         * @return true成功 false失败
         */
        Boolean set(String key, Object value);

        /**
         * 普通缓存放入并设置时间
         *
         * @param key   键
         * @param value 值
         * @param secondTime  时间(秒) time要大于0 如果time小于等于0 将设置无限期
         * @return true成功 false 失败
         */
        Boolean set(String key, Object value, Long secondTime);

        /**
         * 普通缓存放入并设置时间
         *
         * @param key   键
         * @param value 值
         * @param time  时间 time要大于0 如果time小于等于0 将设置无限期
         * @param timeUnit 时间单位
         * @return true成功 false 失败
         */
        Boolean set(String key, Object value, Long time, TimeUnit timeUnit);

        Boolean setnx(String key, Object value);

        Boolean setnx(String key, Object value, Long secondTime);

        Boolean setnx(String key, Object value, Long time, TimeUnit timeUnit);

        Boolean setex(String key, Object value);

        Boolean setex(String key, Object value, Long secondTime);

        Boolean setex(String key, Object value, Long time, TimeUnit timeUnit);
        
        /**
         * 获取旧值，设置新值
         * @param key 键
         * @param value 值
         * @return 旧值
         */
        Object getSet(String key, Object value);

        /**
         * 递增
         *
         * @param key   键
         * @param delta 要增加几(大于0)
         * @return
         */
        void incrBy(String key, Long delta);

        /**
         * 递减
         *
         * @param key   键
         * @param delta 要减少几(小于0)
         * @return
         */
        void decrBy(String key, Long delta);

        /**
         * 递增
         *
         * @param key   键
         * @param delta 要增加几(大于0)
         * @return
         */
        void incrByFloat(String key, double delta);

        /**
         * 递减
         *
         * @param key   键
         * @param delta 要减少几(小于0)
         * @return
         */
        void decrByFloat(String key, double delta);

        /**
         * HashGet
         *
         * @param key  键 不能为null
         * @param item 项 不能为null
         * @return 值
         */
        Object hget(String key, String item);

        /**
         * 获取hashKey对应的所有键值
         *
         * @param key 键
         * @return 对应的多个键值
         */
        Map<Object, Object> hgetAll(String key);

        /**
         * HashSet
         *
         * @param key 键
         * @param map 对应多个键值
         * @return true 成功 false 失败
         */
        Boolean hset(String key, Map<String, Object> map);

        /**
         * HashSet 并设置时间
         *
         * @param key  键
         * @param map  对应多个键值
         * @param time 时间(秒)
         * @return true成功 false失败
         */
        Boolean hset(String key, Map<String, Object> map, Long time);

        /**
         * 向一张hash表中放入数据,如果不存在将创建
         *
         * @param key   键
         * @param item  项
         * @param value 值
         * @return true 成功 false失败
         */
        Boolean hset(String key, String item, Object value);

        /**
         * 向一张hash表中放入数据,如果不存在将创建
         *
         * @param key   键
         * @param item  项
         * @param value 值
         * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
         * @return true 成功 false失败
         */
        Boolean hset(String key, String item, Object value, Long time);

        Boolean hset(String key, String item, Object value, Long time, TimeUnit timeUnit);

        /**
         * 删除hash表中的值
         *
         * @param key  键 不能为null
         * @param item 项 可以使多个 不能为null
         */
        void hdel(String key, Object... item);

        /**
         * 判断hash表中是否有该项的值
         *
         * @param key  键 不能为null
         * @param item 项 不能为null
         * @return true 存在 false不存在
         */
        Boolean hHasKey(String key, String item);

        /**
         * hash递增 如果不存在,就会创建一个 并把新增后的值返回
         *
         * @param key  键
         * @param item 项
         * @param by   要增加几(大于0)
         * @return
         */
        double hincr(String key, String item, double by);

        /**
         * hash递减
         *
         * @param key  键
         * @param item 项
         * @param by   要减少记(小于0)
         * @return
         */
        double hdecr(String key, String item, double by);

        /**
         * 根据key获取Set中的所有值
         *
         * @param key 键
         * @return
         */
        Set<Object> smembers(String key);

        /**
         * 根据value从一个set中查询,是否存在
         *
         * @param key   键
         * @param value 值
         * @return true 存在 false不存在
         */
        Boolean sismember(String key, Object value);

        /**
         * 将set数据放入缓存
         *
         * @param key    键
         * @param values 值 可以是多个
         * @param time   时间(秒)
         * @return 成功个数
         */
        Long sadd(String key, Long time, Object... values);

        Long sadd(String key, Long time, TimeUnit timeUnit, Object... values);

        Long sadd(String key, Object... values);
        /**
         * 获取set缓存的长度
         *
         * @param key 键
         * @return
         */
        Long scard(String key);

        /**
         * 移除值为value的
         *
         * @param key    键
         * @param values 值 可以是多个
         * @return 移除的个数
         */
        Long srem(String key, Object... values);

        /**
         * 集合元素移动
         * @param sourceKey 源
         * @param targetKey 目标
         * @param value 值
         * @return
         */
        Boolean smove(String sourceKey, String targetKey, Object value);

        /**
         * 获取list缓存的内容
         *
         * @param key   键
         * @param start 开始
         * @param end   结束 0 到 -1代表所有值
         * @return
         */
        List<Object> lrange(String key, Long start, Long end);

        /**
         * 获取list缓存的长度
         *
         * @param key 键
         * @return
         */
        Long llen(String key);

        /**
         * 通过索引 获取list中的值
         *
         * @param key   键
         * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
         * @return
         */
        Object lindex(String key, Long index);

        /**
         * 将list放入缓存
         *
         * @param key   键
         * @param value 值
         * @return
         */
        Boolean lpush(String key, Object value);


        Boolean rpush(String key, Object value);
        /**
         * 将list放入缓存
         *
         * @param key   键
         * @param value 值
         * @return
         */
        Boolean lpush(String key, List<Object> value);

        /**
         * 将list放入缓存
         *
         * @param key   键
         * @param value 值
         * @return
         */
        Boolean rpush(String key, List<Object> value);

        /**
         * 根据索引修改list中的某条数据
         *
         * @param key   键
         * @param index 索引
         * @param value 值
         * @return
         */
        Boolean lset(String key, Long index, Object value);

        /**
         * 移除N个值为value
         *
         * @param key   键
         * @param count 移除多少个
         * @param value 值
         * @return 移除的个数
         */
        Long lrem(String key, Long count, Object value);

        /**
         * 从redis集合中移除[start,end]之间的元素
         *
         * @param key
         * @param start
         * @param end
         * @return
         */
        void ltrim(String key, Long start, Long end);

        Boolean zadd(String key, Object value, Double score);

        Long zadd(String key, Map<Object, Double> values);

        Set<Object> zrange(String key, Long start, Long end);

        Long zrem(String key, Object...values);
}
