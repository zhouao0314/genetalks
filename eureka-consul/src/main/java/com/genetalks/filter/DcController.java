package com.genetalks.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhou on 2018/1/3 0003.
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping({"","/"})
    public String index(){
        return "Hi,dy_bom! this is  provider-node1 of peer!";
    }

    /**
     * 用来测试与节点2.3的负载均衡
     * @return
     */
    @GetMapping("/index")
    public String providerIndex(){
        return "Hi,dy_bom! this is  provider-node1 of peer!";
    }

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}