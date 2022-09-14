package org.zgg.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.zgg.mybatis.bean.Emp;

import java.util.List;

public interface CacheMapper {

    // 根据id查员工信息
    Emp getEmpById(@Param("eid") Integer eid);

    // 插入一条员工信息
    int insertEmp(Emp emp);
}
