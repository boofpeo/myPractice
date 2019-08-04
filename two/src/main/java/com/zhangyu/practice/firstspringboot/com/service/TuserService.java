package com.zhangyu.practice.firstspringboot.com.service;

import com.zhangyu.practice.firstspringboot.com.dao.mapper.TuserMapper;
import com.zhangyu.practice.firstspringboot.com.entity.Tuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuserService {

    @Autowired
    private TuserMapper tuserMapper;

    public Tuser getphone(int userId){
        return tuserMapper.selectHpone(userId);
    }
}
