package org.zgg.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.zgg.mybatis.bean.Dept;

public interface DeptMapper {

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息【多对一】
     * 分步查询第二步：通过did查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    // 根据部门id，获取部门以及部门中所有的员工信息
    Dept getDeptAndEmpByDeptid(@Param("did") Integer did);

    /**
     * 通过分步查询查询部门以及部门中所有的员工信息 【一对多】
     * 分步查询第一步：查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);
}
