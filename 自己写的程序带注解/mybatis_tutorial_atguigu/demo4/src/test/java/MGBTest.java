import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zgg.mybatis.bean.Emp;
import org.zgg.mybatis.bean.EmpExample;
import org.zgg.mybatis.mapper.EmpMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.util.List;

public class MGBTest {

    @Test
    public void test(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询所有数据
//        List<Emp> emps = mapper.selectByExample(null);
//        emps.forEach(System.out::println);

        //根据条件查询  QBC查询
//        EmpExample example = new EmpExample();
//        // where () or ()
//        example.createCriteria()
//                .andEmpNameEqualTo("张三")
//                .andAgeGreaterThan(20);
//        example.or().andDidIsNotNull();
//        List<Emp> emps = mapper.selectByExample(example);
//        emps.forEach(System.out::println);

        // 会将性别修改未null
//        Emp emp1 = new Emp(1, "admin", 22, null, "456@qq.com", 3);
//        mapper.updateByPrimaryKey(emp1);
        // 不会将性别修改未null
        Emp emp2 = new Emp(14, "admin", 22, null, "456@qq.com", 3);
        mapper.updateByPrimaryKeySelective(emp2);
    }
}
