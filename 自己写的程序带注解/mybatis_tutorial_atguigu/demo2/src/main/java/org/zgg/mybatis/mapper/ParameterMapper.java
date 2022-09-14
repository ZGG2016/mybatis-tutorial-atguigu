package org.zgg.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.zgg.mybatis.bean.User;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    // 登录检查  param注解
    User checkLoginByParam(@Param("name") String username, @Param("passwd") String password);

    // 插入用户
    void insertUser(User user);

    // 登录检查，参数为map集合
    User checkLoginByMap(Map<String,String> map);

    // 登录检查
    User checkLogin(String username, String password);

    // 根据用户名获取用户
    User getUserByUsername(String username);

    // 查询所有用户
    List<User> getUsers();
}
