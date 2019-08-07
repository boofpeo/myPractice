package com.zhangyu.three.controller;

import com.zhangyu.three.Config.ConfigBean;
import com.zhangyu.three.Config.ResourceConfig;
import com.zhangyu.three.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping( value = "/hello")
    public Object hello() {
        StringBuffer strb = new StringBuffer();
        strb.append("name :");
        strb.append(resourceConfig.getName());
        strb.append("  age:");
        strb.append(resourceConfig.getAge());
        return strb.toString();
    }

    @RequestMapping( value = "/gogo")
    public Object gogo() {
        String name = configBean.getName();
        return name;
    }
    @RequestMapping( value = "/redis")
    public Object redis(@RequestParam( value = "operate") boolean operate,
                        @RequestParam( value = "key") String key ,
                        @RequestParam( value = "value",required = false) String value) {

        if (operate) {
            boolean flag = redisUtil.set(key, value);
            if (flag) {
                return "success";
            } else {
                return "failure";
            }
        } else {
            Object obj = redisUtil.get(key);
            return obj;
        }
    }
}
