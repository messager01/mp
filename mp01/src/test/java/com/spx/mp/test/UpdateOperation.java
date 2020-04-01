package com.spx.mp.test;

import com.spx.mp.beans.Employee;
import com.spx.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by Shipeixin on 2020/4/1 16:02
 */
public class UpdateOperation {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ioc.getBean("EmployeeMapper",EmployeeMapper.class);

    /**
     *   通用更新方法
     */

    @Test
    public void test(){

        // 初始化修改对象
        Employee employee = new Employee();

        employee.setId(6);
        employee.setLastName("MyBatisPlus");
        employee.setEmail("MyBatisEamil");
        employee.setGender(0);
        //employee.setAge(33);

        // UPDATE tbl_employee SET last_name=?, email=?, gender=? WHERE id=?  操作之前先判空
        //Integer integer = employeeMapper.updateById(employee);

        // UPDATE tbl_employee SET last_name=?,email=?,gender=?,age=? WHERE id=?
        // 不判空，对所有字段都进行修改，这样可能会导致部分字段为null
        // Parameters: MyBatisPlus(String), MyBatisEamil(String), 0(Integer), null, 6(Integer)
        Integer integer = employeeMapper.updateAllColumnById(employee);

        System.out.println(integer);
    }
}
