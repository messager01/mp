package com.spx.mp.test;

import com.spx.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by Shipeixin on 2020/4/1 16:40
 */
public class DeleteOperation {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ioc.getBean("EmployeeMapper",EmployeeMapper.class);



    //  根据id进行删除
    @Test
    public void test1(){
        // DELETE FROM tbl_employee WHERE id=?
        Integer integer = employeeMapper.deleteById(12);
        System.out.println(integer);  //  返回对数据库的影响条数
    }

    //  按条件删除
    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        map.put("last_name","mp");
        map.put("age",22);
        // DELETE FROM tbl_employee WHERE last_name = ? AND age = ?
        Integer integer = employeeMapper.deleteByMap(map);
        System.out.println(integer);  // 影响条数
    }

    // 批量删除
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(5, 6, 11);
        // DELETE FROM tbl_employee WHERE id IN ( ? , ? , ? )
        Integer integer = employeeMapper.deleteBatchIds(list);
        System.out.println(integer);   //  返回影响条数
    }
}
