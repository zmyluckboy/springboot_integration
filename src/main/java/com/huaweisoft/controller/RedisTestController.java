package com.huaweisoft.controller;

import com.huaweisoft.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisTestController {
    @Autowired
    private StringRedisTemplate redisTpl;

    @GetMapping(value = "add")
    public Object add(){
        redisTpl.opsForValue().set("name","zmy");
        return JsonData.buildSuccess("ok");
    }

    @GetMapping(value = "get")
    public Object get(){
        String value = redisTpl.opsForValue().get("name");
        return JsonData.buildSuccess(value);
    }
}
