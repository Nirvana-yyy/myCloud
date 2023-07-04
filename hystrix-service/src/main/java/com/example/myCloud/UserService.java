package com.example.myCloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Yan Jiale
 * @since 2023/07/03 17:24
 */
@Service
public class UserService {

    @Value("${service-url.user-service}")
    private String serviceUrl;

    private RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @HystrixCommand(fallbackMethod = "getDefault")
    public String getUser(){

        return restTemplate.getForObject(serviceUrl+"/user/get", String.class);
    }

    public String getDefault(){
        return "降级方法。。";
    }

    /**
     *     fallbackMethod：指定服务降级处理方法；
     *     ignoreExceptions：忽略某些异常，不发生服务降级；
     *     commandKey：命令名称，用于区分不同的命令；
     *     groupKey：分组名称，Hystrix会根据不同的分组来统计命令的告警及仪表盘信息；
     *     threadPoolKey：线程池名称，用于划分线程池。
     *
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "getDefault",
                    commandKey = "test",
                    groupKey = "testGroup",
                    threadPoolKey = "testThreadPool")
    public String test() {
        return restTemplate.getForObject(serviceUrl+"/user/get", String.class);
    }
}
