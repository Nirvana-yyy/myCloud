package com.example.myCloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yan Jiale
 * @since 2023/07/10 11:28
 */

@FeignClient("user-service")
public interface UserService {
    @GetMapping("user/get")
    public String get();

}
