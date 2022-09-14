package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.zgg.mybatis.mapper.SelectMapper;
import org.zgg.mybatis.util.SqlSessionUtils;

import java.io.IOException;

public class SelectMapperTest {
    @Test
    public void test() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

//        System.out.println(org.zgg.mybatis.mapper.getUserById(3));

//        System.out.println(org.zgg.mybatis.mapper.getAllUser());

//        System.out.println(org.zgg.mybatis.mapper.getCount());

//        System.out.println(org.zgg.mybatis.mapper.getUserByIdToMap(3));

//        System.out.println(org.zgg.mybatis.mapper.getAllUserToMap1());

        System.out.println(mapper.getAllUserToMap2());
    }
}
