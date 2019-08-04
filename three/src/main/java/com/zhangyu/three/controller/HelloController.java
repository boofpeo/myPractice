package com.zhangyu.three.controller;

import com.zhangyu.three.Config.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/2 16:26
 */
@RestController
public class HelloController {

    @Autowired
    private ResourceConfig resourceConfig;

    @RequestMapping( value = "/hello")
    public Object hello() {
        StringBuffer strb = new StringBuffer();
        strb.append("name :");
        strb.append(resourceConfig.getName());
        strb.append("  age:");
        strb.append(resourceConfig.getAge());
        return strb.toString();
    }
}
