package com.zhangyu.three.practicedemo.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TAnnotation {
    String value();				//这里没有给默认值,那么在使用的时候就必须给值,相当于是给方法实现
    int age() default 18;		//还可以给默认值,给了默认值在使用的时候就可以不用给值
    String[] favs() default {"java","js"};  //数据类型可以是数组
    String msg() default "this is myAnnotation"; //default 默认值
}
