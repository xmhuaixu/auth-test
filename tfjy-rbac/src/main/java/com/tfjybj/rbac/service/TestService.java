package com.tfjybj.rbac.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tfjybj.common.utils.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * User: Banana
 * Date: 2020/5/23
 * Time: 8:31
 * DingDing: 17731618462
 * Description:
 **/

@Service
public class TestService {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${server.port}")
    private String serverPort;

    @HystrixCommand(fallbackMethod = "getFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String get(Long id) {
        if (id < 0) {
            throw new RuntimeException("id<0");
        }
        redisUtil.set("id:" + id, id);
        System.out.println(redisUtil.get("id:" + id));
        return "nacos registry id: " + id + " port: " + serverPort;
    }

    public String getFallback(Long id) {
        return "id为负数，调用get失败，fallback";
    }
}