package com.zhangyu.dubbo.demo.springbootdubboprovide;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;


@EnableDubbo
@SpringBootApplication
public class SpringbootDubboProvideApplication implements CommandLineRunner {

	public static void main(String[] args)  throws InterruptedException{
		SpringApplication.run(SpringbootDubboProvideApplication.class, args);
		TimeUnit.MINUTES.sleep(10); //提供者main线程暂停10分钟等待被调用
		System.err.println("服务提供者------>>服务关闭");
	}

	@Override
	public void run(String... args) throws Exception {
		System.err.println("服务提供者------>>启动完毕");
	}
}
