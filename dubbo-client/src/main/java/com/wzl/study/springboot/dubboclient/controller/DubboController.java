package com.wzl.study.springboot.dubboclient.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wzl.study.springboot.service.DubboService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    @Reference(version ="1.0.0",group ="test" )
    private DubboService dubboService;

    @ApiOperation(value="测试",notes = "整合springboot集成dubbo")
    @ApiImplicitParam(name="name",value = "名字",required = true,dataType = "String")
    @RequestMapping(value = "/name" ,method = RequestMethod.GET)
    public String getName(String name){
        return dubboService.getName(name);
    }


}
