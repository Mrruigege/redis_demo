package com.example.redis_demo;

import com.example.redis_demo.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author dengR
 * @date 2022/4/27 20:31
 */
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void testSet() {
        List<Object> mylist = redisService.lrange("mylist", 0L, -1L);
        System.out.println(mylist);
    }
}
