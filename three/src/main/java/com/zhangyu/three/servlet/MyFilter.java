package com.zhangyu.three.servlet;


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * filter 可以对servlet名称，路径，类型做过滤，
 * 先后顺序将通过名称的首字母或者是数字大小来排序
 */

@WebFilter(
        servletNames = "myservlet"
)
public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();

        servletContext.log("filter");

        filterChain.doFilter(request, response);

    }
}
