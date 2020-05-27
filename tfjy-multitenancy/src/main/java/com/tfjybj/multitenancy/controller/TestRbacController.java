package com.tfjybj.multitenancy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
//import com.tfjybj.common.utils.redis.RedisUtil;
import com.tfjybj.multitenancy.service.TestRbacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableDiscoveryClient
@DefaultProperties(defaultFallback = "defaultFallbackHandler")
public class TestRbacController {

//    @Resource
//    private RedisUtil redisUtil;

    @Value("${server.port}")
    private String serverPort;

    @Value("${service-url.rbac-service}")
    private String RbacURL;

    @Resource
    private TestRbacService testRbacService;

    @GetMapping("/multitenancy/rbac/test/{id}")
    public String get(@PathVariable("id") Long id) {
        return testRbacService.get(id);
    }

    @GetMapping("/multitenancy/rbac/testfallback/{id}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String testInvoke(@PathVariable("id") Long id) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        redisUtil.set("id:" + id, id);
//        System.out.println(redisUtil.get("id:" + id));
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }

    public String defaultFallbackHandler() {
        return "默认调用失败！";
    }
}
