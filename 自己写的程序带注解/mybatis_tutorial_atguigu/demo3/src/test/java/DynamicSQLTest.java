import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zgg.mybatis.bean.Dept;
import org.zgg.mybatis.bean.Emp;
import org.zgg.mybatis.mapper.DeptMapper;
import org.zgg.mybatis.mapper.DynamicSQLMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// 动态sqll
public class DynamicSQLTest {

    @Test
    public void test() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

//        List<Emp> emp = mapper.getEmpByCondition(new Emp(null,"张三",23,"男","123@qq.com",null));
//        List<Emp> emp = mapper.getEmpByCondition(new Emp(null,"张三",23,"男","",null));
//        List<Emp> emp = mapper.getEmpByCondition(new Emp(null,"张三",null,"男","",null));
//        List<Emp> emp = mapper.getEmpByCondition(
//                new Emp(null, "", null, "", "", null));

        //---------------------------------------------------
//        List<Emp> emp = mapper.getEmpByChoose(
//                new Emp(null, "张三", 23, "男", "123@qq.com", null));

//        List<Emp> emp = mapper.getEmpByChoose(
//                new Emp(null, "", null, "", "", null));
//        System.out.println(emp);

        //---------------------------------------------------
//        int i = mapper.deleteMoreByArray(new Integer[]{8, 9});
//        Emp emp1 = new Emp(null,"a1",23,"男","123@qq.com",null);
//        Emp emp2 = new Emp(null,"a2",23,"男","123@qq.com",null);
//        Emp emp3 = new Emp(null,"a3",23,"男","123@qq.com",null);
//        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
//
//        int i = mapper.insertMoreByList(emps);
//        System.out.println(i);

        //---------------------------------------------------
        List<Emp> emps = mapper.getEmps();
        System.out.println(emps);
    }
}
