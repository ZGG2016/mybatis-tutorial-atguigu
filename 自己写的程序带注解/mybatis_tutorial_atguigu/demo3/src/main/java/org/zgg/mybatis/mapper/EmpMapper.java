package org.zgg.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.zgg.mybatis.bean.Emp;

import java.util.List;

public interface EmpMapper {

    // 获取所有员工信息
    List<Emp> getEmps();

    // 根据员工id获取员工信息，包含所属部门
    Emp getEmpAndDeptById(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息【多对一】
     * 分步查询第一步：查询员工信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息 【一对多】
     * 分步查询第二步：根据did查询员工信息
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
