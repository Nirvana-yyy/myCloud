package com.example.myCloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yan Jiale
 * @since 2023/07/10 12:25
 */
@RestController
@RequestMapping("/user")
public class FeignUserController {

    private UserService userService;

    public FeignUserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping("/get")
    public String get(){
        return userService.get();
    }

}
