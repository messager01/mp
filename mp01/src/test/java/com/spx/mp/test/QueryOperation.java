package com.spx.mp.test;

import com.baomidou.mybatisplus.plugins.Page;
import com.spx.mp.beans.Employee;
import com.spx.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * create by Shipeixin on 2020/4/1 16:13
 */
public class QueryOperation {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ioc.getBean("EmployeeMapper",EmployeeMapper.class);


    /**
     *   通用查询操作
     */


    //   通过 id 查询
    @Test
    public void test1(){
        Employee employee = employeeMapper.selectById(6);
        System.out.println(employee);
    }
    

    //  通过多个列查询，及多个条件插叙
    //  需求：通过 id+lastname查询
    @Test
    public void test2(){
        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("MyBatisPlus");
        // selectOne  最多只能查一条数据
        //SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE id=? AND last_name=?
        Employee employee1 = employeeMapper.selectOne(employee);
        System.out.println(employee1);
    }


    //  需求：通过多个 id 查询
    //  mybatis 中 需要使用 foreach 来迭代
    @Test
    public void test3(){

        List<Integer> idList = Arrays.asList(10, 11, 12);
        //  SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE id IN ( ? , ? , ? )
        List<Employee> employees = employeeMapper.selectBatchIds(idList);
        System.out.println(employees);
    }

    //  多条件查询  selectByMap  输入一个map  把条件用map 包装传入  返回得到一个集合
    // map 中的 key 值要使用数据库中的 字段值 不能用实体类中的属性名
    @Test
    public void test4(){
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("last_name","MyBatisPlus");
        columnMap.put("gender",0);
        //SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE gender = ? AND last_name = ?
        List<Employee> employees = employeeMapper.selectByMap(columnMap);
        System.out.println(employees);
    }


    //  分页查询
    @Test
    public void test5(){
        // 假分页 内存分页  并不是物理分页，SQL中并没有limit  使用的是rowbounds 查询
        // SELECT id,last_name AS lastName,email,gender,age FROM tbl_employee
        List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 2), null);
        System.out.println(employees);
    }
}
