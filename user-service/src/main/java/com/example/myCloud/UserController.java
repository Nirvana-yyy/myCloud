package com.example.myCloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Yan Jiale
 * @since 2023/06/30 17:23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/get")
    public String get(){
        System.out.println("======>get..<======");
        return "get ...";
    }

}
