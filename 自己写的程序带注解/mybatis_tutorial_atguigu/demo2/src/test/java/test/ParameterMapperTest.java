package test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.zgg.mybatis.bean.User;
import org.zgg.mybatis.mapper.ParameterMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


public class ParameterMapperTest {
    @Test
    public void test() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

//        List<User> list = org.zgg.mybatis.mapper.getUsers();
//        list.forEach(System.out::println);

//        User user = org.zgg.mybatis.mapper.getUserByUsername("admin");
//        System.out.println(user);

//        User user = org.zgg.mybatis.mapper.checkLogin("admin", "123456");
//        System.out.println(user);

//        HashMap<String, String> map = new HashMap<>();
//        map.put("username","admin");
//        map.put("password","123456");
//        User user = org.zgg.mybatis.mapper.checkLoginByMap(map);
//        System.out.println(user);

//        User user = new User(null, "lisi", "345", 12, "男", "3456@qq.com");
//        org.zgg.mybatis.mapper.insertUser(user);

        User user = mapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }
}
