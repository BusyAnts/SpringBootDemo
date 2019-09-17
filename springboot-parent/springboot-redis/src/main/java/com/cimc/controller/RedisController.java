package com.cimc.controller;

import com.cimc.util.JsonData;
import com.cimc.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenz
 * @create 2019-09-17 11:00
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping(value = "add")
    public Object add() {
        redisTemplate.opsForValue().set("name", "james");
        return JsonData.buildSuccess();
    }

    @GetMapping(value = "get")
    public Object get() {
        String value = redisTemplate.opsForValue().get("name");
        return JsonData.buildSuccess(value);
    }

    @GetMapping(value = "set")
    public Object set() {
        redisUtil.set("sports", "basketball", 10);
        return JsonData.buildSuccess();
    }
}
