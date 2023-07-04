package com.example.myCloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yan Jiale
 * @since 2023/07/03 16:37
 */
@RestController
@RequestMapping("/user")
public class UserHystrixController {

    private UserService userService;



    public UserHystrixController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/get")
    public String get(){
        return userService.getUser();
    }

    @RequestMapping("/test")
    public String test(){
        return userService.test();
    }
}
