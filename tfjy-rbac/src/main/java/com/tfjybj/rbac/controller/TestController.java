package com.tfjybj.rbac.controller;

import com.tfjybj.rbac.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("测试Controller")
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private TestService testService;

    @GetMapping(value = "/rbac/nacos/{id}")
    @ApiOperation("根据id获取测试方法")
    public String get(@PathVariable("id") Long id) {
        return testService.get(id);
    }

}
