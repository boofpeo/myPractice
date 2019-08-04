package com.zhangyu.practice.firstspringboot.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Tuser {


    //    @JsonIgnore Json转换忽略
    private String userId;
    //    @JsonInclude(JsonInclude.Include.NON_NULL) 如果为空 不显示
    private String username;
    //   时间的格式
//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a" ,locale = "zh",timezone = "GMT+8")
    private String phone;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
