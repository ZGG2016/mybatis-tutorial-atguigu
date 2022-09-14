import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zgg.mybatis.bean.Dept;
import org.zgg.mybatis.bean.Emp;
import org.zgg.mybatis.mapper.DeptMapper;
import org.zgg.mybatis.mapper.EmpMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.io.IOException;
import java.util.List;

// ResultMap
public class ResultMapTest {

    @Test
    public void test() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//        List<Emp> emps = mapper.getEmps();
//        System.out.println(emps);

//        Emp emp = mapper.getEmpAndDeptById(1);
//        System.out.println(emp);

//        Emp emp = mapper.getEmpAndDeptByStepOne(1);
////        System.out.println(emp);
////        懒加载: 访问什么属性，就会执行相应的sql
//        System.out.println(emp.getEmpName());
//        System.out.println("------------------");
//        System.out.println(emp.getDept());
//
//        DeptMapper mapper2 = sqlSession.getMapper(DeptMapper.class);
//        Dept dept = mapper2.getEmpAndDeptByStepTwo(1);
//        System.out.println(dept.getDeptName());
        //--------------------------------------------------

        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
//        Dept dept = mapper.getDeptAndEmpByDeptid(1);
//        System.out.println(dept);

        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept.getDeptName());
    }
}
