package com.example.demo.configure;

import com.example.demo.servlet.TestServlet;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;

@Configuration
//自动装配servlet方式二
@ServletComponentScan
public class ServletConfiguration  {


   /* //注册自定义的servlet的方式一
    @Bean
    public ServletRegistrationBean servletRegistration(){
        return new ServletRegistrationBean(new TestServlet(),"/test1");
    }*/
}
