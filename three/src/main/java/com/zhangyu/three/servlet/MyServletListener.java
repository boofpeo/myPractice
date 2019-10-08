package com.zhangyu.three.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class MyServletListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {

        HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("init");
    }

    public void requestDestroyed(ServletRequestEvent requestEvent) {

        HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("Des");
    }
}
