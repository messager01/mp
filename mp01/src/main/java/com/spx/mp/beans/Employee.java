package com.spx.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * create by Shipeixin on 2020/3/31 22:22
 */

/*
*
*   定义javabean 时 ，成员变量所使用的类型：
*    建议使用包装类型，因为每个基本类型都有一个默认值
* */

/**
 *   mybatisplus 会默认使用实体类的类名到数据库中去找对应的表
 */
/*@TableName(value = "tbl_employee")*/
public class Employee {

    /*
    *   TableId:
    *      value:指定表中的主键列的列名，如果实体类属性名和列名一致，可以省略不写
    *      type: 指定主键策略
    * */

    /*@TableId(value = "id",type = IdType.AUTO)*/
    private Integer id;

    @TableField(value = "last_name")     // 类似于变相的开启驼峰命名
    private String lastName;

    private String email;

    private Integer gender;

    private Integer age;

    @TableField(exist = false)   //  表示salary字段并不在数据库字段中
    private Double salary;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
