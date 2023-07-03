package com.example.myCloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.PriorityQueue;

/**
 * @author Yan Jiale
 * @since 2023/06/30 18:16
 */
@RestController
@RequestMapping("/user")
public class UserRibbonController {

//    @Autowired
    private RestTemplate restTemplate ;

    @Value("${service-url.user-service}")
    private String serviceUrl;

//    @Autowired
    public UserRibbonController(RestTemplate restTemplate) {
        System.out.println("有参构造");
        this.restTemplate = restTemplate;
    }



    @RequestMapping("/get")
    public String get(){
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
        return restTemplate.getForObject(serviceUrl+"/user/get", String.class);
    }

}
