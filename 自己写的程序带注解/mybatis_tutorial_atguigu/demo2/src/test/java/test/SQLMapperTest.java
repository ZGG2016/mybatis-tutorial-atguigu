package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zgg.mybatis.bean.User;
import org.zgg.mybatis.mapper.SQLMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.io.IOException;
import java.util.List;

public class SQLMapperTest {
    @Test
    public void test() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);

//        List<User> list = org.zgg.mybatis.mapper.getUserByLike("a");
//        System.out.println(list);

//        int i = org.zgg.mybatis.mapper.deleteMore("2,3");
//        System.out.println(i);

//        List<User> users = org.zgg.mybatis.mapper.getUserByTableName("t_user");
//        System.out.println(users);

        User user = new User(null, "lisi", "345", 12, "男", "3456@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }
}
