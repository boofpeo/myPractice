package com.zhangyu.practice.firstspringboot.com.dao.mapper;


import com.zhangyu.practice.firstspringboot.com.entity.Tuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TuserMapper {

//    @Select("SELECT T.phone FROM t_user T WHERE T.user_id =#{userId}")
     Tuser selectHpone(@Param("userId") int userId);

}
