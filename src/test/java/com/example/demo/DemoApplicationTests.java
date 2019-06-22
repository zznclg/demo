package com.example.demo;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Resource
    EmployeeDao employeeDao;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test(){

        Employee employee = employeeDao.getEmployee("Jhon");
        System.out.printf(employee.toString());
    }

}
