package com.example.demo.dao;

import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface EmployeeDao {

    //使用多参数动态查询的时候必须加上参数注解
    public Employee getEmployee(@Param("first_name") String first_name);

    public List<Employee> getList();
}
