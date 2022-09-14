import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.zgg.mybatis.bean.Emp;
import org.zgg.mybatis.mapper.CacheMapper;
import org.zgg.mybatis.mapper.DynamicSQLMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// 缓存
public class CacheTest {
    /*
       一级缓存是【SqlSession级别】的，通过同一个SqlSession查询的数据会被缓存，
       下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问
     */
    // 一级缓存测试，日志只会输出一次sql语句
    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp1);
        System.out.println(emp2);
    }

    // 一级缓存测试，日志只会输出两次次sql语句
    @Test
    public void test2() throws IOException {
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
    }

    // 一级缓存失效测试
    /*
        1) 不同的SqlSession对应不同的一级缓存
        2) 同一个SqlSession但是查询条件不同
        3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
        4) 同一个SqlSession两次查询期间手动清空了缓存
     */
    @Test
    public void test3() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        System.out.println("------------------------------");
        // 执行一次插入
//        int i = mapper.insertEmp(
//                new Emp(null, "abc", 23, "男", "123@qq.com",null));

        // 手动清空了缓存
        sqlSession.clearCache();

        System.out.println("------------------------------");
        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
    }

    // 测试二级缓存
    /*
       二级缓存是SqlSessionFactory级别，
       通过同一个SqlSessionFactory创建的SqlSession查询的结果会被缓存；
       此后若再次执行相同的查询语句，结果就会从缓存中获取二级缓存开启的条件：
            a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
            b>在映射文件中设置标签 <cache />
            c>二级缓存必须在SqlSession关闭或提交之后有效
            d>查询的数据所转换的实体类类型必须实现序列化的接口

      使二级缓存失效的情况：
          两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
     */
    @Test
    public void test4() throws IOException {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession();
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            Emp emp1 = mapper1.getEmpById(1);
            System.out.println(emp1);
            sqlSession1.close();

            System.out.println("------------------");

            SqlSession sqlSession2 = sqlSessionFactory.openSession();
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            Emp emp2 = mapper2.getEmpById(1);
            System.out.println(emp2);
            sqlSession2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
       MyBatis缓存查询的顺序:
            先查询二级缓存
            再查询一级缓存
            查询数据库
            SqlSession关闭之后，一级缓存中的数据会写入二级缓存
     */
}
