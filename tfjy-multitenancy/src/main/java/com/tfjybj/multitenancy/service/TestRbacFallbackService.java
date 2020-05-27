package com.tfjybj.multitenancy.service;

import org.springframework.stereotype.Component;

/**
 * User: Banana
 * Date: 2020/5/22
 * Time: 15:45
 * DingDing: 17731618462
 * Description:
 **/

@Component
public class TestRbacFallbackService implements TestRbacService {

    @Override
    public String get(Long id) {
        return "┭┮﹏┭┮ 调用失败！！";
    }

}