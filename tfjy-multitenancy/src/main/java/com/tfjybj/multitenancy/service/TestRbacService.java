package com.tfjybj.multitenancy.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * User: Banana
 * Date: ${DATE}
 * Time: ${TIME}
 * DingDing: 17731618462
 * Description:
 **/

@Component
@FeignClient(value = "tfjy-auth3-rbac-service", fallback = TestRbacFallbackService.class)
public interface TestRbacService {

    @GetMapping("/rbac/nacos/{id}")
    String get(@PathVariable("id") Long id);

}
