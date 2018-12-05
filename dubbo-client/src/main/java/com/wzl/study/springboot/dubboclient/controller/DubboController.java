package com.wzl.study.springboot.dubboclient.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wzl.study.springboot.service.DubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    @Reference(version ="1.0.0",group ="test" )
    private DubboService dubboService;
    @RequestMapping("/name")
    public String getName(String name){
        return dubboService.getName(name);
    }


}
