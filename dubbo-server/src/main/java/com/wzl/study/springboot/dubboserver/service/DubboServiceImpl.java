package com.wzl.study.springboot.dubboserver.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wzl.study.springboot.service.DubboService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0",group = "test")
public class DubboServiceImpl implements DubboService {
    @Override
    public String getName(String name) {
        return "Hello " + name;
    }
}
