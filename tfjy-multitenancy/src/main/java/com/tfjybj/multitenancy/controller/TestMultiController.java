package com.tfjybj.multitenancy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Banana
 * Date: 2020/5/22
 * Time: 14:01
 * DingDing: 17731618462
 * Description:
 **/

@RestController
public class TestMultiController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/multi/get/{id}")
    public String testInvoke(@PathVariable("id") Long id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }

}