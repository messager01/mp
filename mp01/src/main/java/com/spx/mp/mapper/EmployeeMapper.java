package com.spx.mp.mapper;

/**
 * create by Shipeixin on 2020/3/31 22:47
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.spx.mp.beans.Employee;
import org.springframework.stereotype.Repository;

/**
 *   mapper 接口
 *   基于mybatis实现：mapper接口中要写crud，还要写mapper接口对应的sql映射文件
 *   基于mp：  让mapper接口继承basemapper 接口即可
 *             basemapper<T> 当前mapper 所操作的实体类型
 */
@Repository(value = "EmployeeMapper")
public interface EmployeeMapper extends BaseMapper<Employee> {
}
