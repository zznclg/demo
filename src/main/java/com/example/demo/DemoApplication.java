package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication/* extends SpringBootServletInitializer*/ {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return new String("hello world!!!");
    }


    //继承了 SpringBootServletInitializer类的子类，必须要重写congigure来实现springboot初始化
    //实现了SpringBootServletInitializer的子类需要重写一个configure方法，
    // 方法内自动根据DemoApplication.class的类型创建一个SpringApplicationBuilder交付给springboot框架来完成初始化运行配置。
    /*@Override*/
    /*protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {*/
    /*    return super.configure(builder);*/
    /*}*/


}
