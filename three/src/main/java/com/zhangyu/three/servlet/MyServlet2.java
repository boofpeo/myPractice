package com.zhangyu.three.servlet;

import com.zhangyu.three.Config.even.MyEven;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author yu.zhang
 * @Description: TODO
 * @date 2019/9/24 17:11
 */
public class MyServlet2 extends HttpServlet implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Writer writer = response.getWriter();

        ServletContext servletContext = getServletContext();

        servletContext.log("servlet2");

        Object giveSpringMyEven = this.applicationContext.getBean("iiispringMyEven");

        writer.write("<html><body>" + "springMyEven.getName()" + "</body></html>");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
