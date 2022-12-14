package org.zgg.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.zgg.mybatis.bean.Emp;

import java.util.List;

public interface DynamicSQLMapper {
    // 多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 测试choose、when、otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

    // 测试sql片段
    List<Emp> getEmps();
}
