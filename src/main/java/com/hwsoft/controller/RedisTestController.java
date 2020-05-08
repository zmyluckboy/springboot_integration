package com.hwsoft.controller;

import com.hwsoft.domain.JsonData;
import com.hwsoft.domain.User;
import com.hwsoft.utils.JsonUtils;
import com.hwsoft.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisTestController {
    @Autowired
    private StringRedisTemplate redisTpl;
    @Autowired
    private RedisClient redisClient;

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

    @GetMapping(value = "comp")
    public Object add_c(){
        redisClient.set("zhao", "yy");
        return JsonData.buildSuccess();
    }
    @GetMapping(value = "compg")
    public Object get_c(){
        String value = redisClient.get("zhao");
        return JsonData.buildSuccess(value);
    }

    @GetMapping(value = "save_user")
    public Object saveUser(){
        User user = new User(1, "abc", "11", new Date());
        String userStr = JsonUtils.obj2Strong(user);
        boolean flag = redisClient.set("base:user:11", userStr);
        return JsonData.buildSuccess(flag);
    }

    @GetMapping(value = "find_user")
    public Object findUser(){
        String userStr = redisClient.get("base:user:11");
        User user = JsonUtils.string2Obj(userStr, User.class);
        return JsonData.buildSuccess(user);
    }

}
