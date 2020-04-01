package com.spx.mp.test;

import com.spx.mp.beans.Employee;
import com.spx.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * create by Shipeixin on 2020/3/31 22:36
 */
public class InsertOperation {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ioc.getBean("EmployeeMapper",EmployeeMapper.class);

   /*   insert()  通用插入操作,该操作并不会对所有字段进行插入，传进来什么字段就插入什么字段，会对每个属性进行非空判断
   *
   *    insertAllColumn()   会对所有字段进行插入
   * */

    // MP 的插入操作可以自动的 将主键值写回到实体类中
    @Test
    public void test1(){
        Employee employee  =  new Employee();
        employee.setLastName("MP");
        employee.setEmail("mp@pp.com");
       // employee.setGender(1);
        //employee.setAge(22);
        employee.setSalary(20000.0);
       // Integer insert = employeeMapper.insert(employee);

  //  INSERT INTO tbl_employee ( last_Name,email,gender,age ) VALUES ( ?,?,?,? )
        Integer insert = employeeMapper.insertAllColumn(employee);

        System.out.println("当前的key值为："+employee.getId());
        System.out.println(insert);
    }



    @Test
    public void testDataSource() throws SQLException {
        DataSource ds = (DataSource) ioc.getBean("dataSource");
        System.out.println(ds);

        Connection connection = ds.getConnection();
        System.out.println(connection);
    }


    @Test
    public void test(){
        System.out.println(employeeMapper);
    }

}
