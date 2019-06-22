package com.example.demo;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@RestController
@MapperScan("com.example.demo.dao")
public class DemoApplication/* extends SpringBootServletInitializer*/ {

    @Autowired(required = true)
    EmployeeDao employeeDao;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Employee> index(){
        return employeeDao.getList();
    }


    @RequestMapping("/index/{number}")
    public String index(@PathVariable int number){
        System.out.println((20/number));
        return "test successfully!!!";
    }




    //继承了 SpringBootServletInitializer类的子类，必须要重写congigure来实现springboot初始化
    //实现了SpringBootServletInitializer的子类需要重写一个configure方法，
    // 方法内自动根据DemoApplication.class的类型创建一个SpringApplicationBuilder交付给springboot框架来完成初始化运行配置。
    /*@Override*/
    /*protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {*/
    /*    return super.configure(builder);*/
    /*}*/


}
