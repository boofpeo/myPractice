package com.zhangyu.three.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;


public class MyServletListener2 implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {

        HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("init2");
    }

    public void requestDestroyed(ServletRequestEvent requestEvent) {

        HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("Des2");
    }
}
