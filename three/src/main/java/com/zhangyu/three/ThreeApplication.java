package com.zhangyu.three;

import com.zhangyu.three.servlet.MyFilter2;
import com.zhangyu.three.servlet.MyServlet2;
import com.zhangyu.three.servlet.MyServletListener2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * 继承SpringBootServletInitializer 组装SpringApplicationBuilder 配置
 * WebMvcProperties spring.mvc.view.prefix
 * spring.mvc.view.suffix
 */


@SpringBootApplication
@ServletComponentScan(basePackages = {"com.zhangyu.three.servlet"})
public class ThreeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ThreeApplication.class, args);
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean() {

        ServletRegistrationBean bean = new ServletRegistrationBean();

        bean.setServlet(new MyServlet2());
        bean.addUrlMappings("/myservlet2");
        bean.setName("myservlet2");

        return bean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new MyFilter2());

        /**
         * REQUEST：普通模式，来自客户端的请求
         * FORWARD：通过RequestDispatcher的forward()，或者<jsp:forward>
         * INCLUDE：通过RequestDispatcher的include()，或者<jsp:include>
         * ERROR：请求错误页面来处理HTTP错误，例如404,500
         * ASYNC：来自AsyncContext的异步请求

         */
//        bean.setDispatcherTypes(DispatcherType.ASYNC);

        bean.addServletNames("myservlet2");

        return bean;

    }

    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean() {

        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();

        bean.setListener(new MyServletListener2());

        return bean;

    }

    /**
     * 组装
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(ThreeApplication.class);
        return builder;
    }

}
