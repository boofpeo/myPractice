package com.zhangyu.three.practicedemo.annotation;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/8/8 10:35
 */
public class TestAnno {

    @TAnnotation(value = "ddd")
    private String msg;

    public String getMm() {
        return msg;
    }

    public static void main(String[] args) {
        TestAnno tn = new TestAnno();
//        System.out.println(tn.getMm());
        Object obj = new Object();
        System.out.println("原始地址" + obj);
        tn.addree(obj);
    }

    public void addree(final Object obj) {
//      地址一致
        System.out.println("引用地址" + obj);
    }
}
