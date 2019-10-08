package com.zhangyu.three.servlet;

import com.zhangyu.three.Config.even.MyEven;
import com.zhangyu.three.Config.even.MyEvenInter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * servlet
 */
@WebServlet(
        name = "myservlet",
        urlPatterns = "/myserv"
)
public class MyServlet extends HttpServlet implements ApplicationContextAware {

    private ApplicationContext applicationContext;

//    @Autowired
    @Resource(name = "myEven")
    private MyEvenInter myEvenInter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Writer writer = response.getWriter();

        ServletContext servletContext = getServletContext();

        servletContext.log("servlet");

        MyEvenInter myEven =(MyEven) this.applicationContext.getBean("myEven");
        String name = myEvenInter.getName();

        writer.write("<html><body>" + myEven.getName() + "</body></html>");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
