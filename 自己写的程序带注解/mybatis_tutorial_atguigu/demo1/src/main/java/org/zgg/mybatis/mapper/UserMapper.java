package org.zgg.mybatis.mapper;

import org.zgg.mybatis.bean.User;

import java.util.List;

/**
 *  MyBatis中的mapper接口相当于以前的dao，
 *  但是区别在于，mapper仅仅是接口，我们不需要提供实现类
 */
public interface UserMapper {

    /*
      MyBatis面向接口编程的两个一致：
        1、映射文件的namespace要和mapper接口的全类名保持一致
        2、映射文件中SQL语句的id要和mapper接口中的方法名一致

      表--实体类--mapper接口--映射文件
      一张表对应一个java类，
      这个java类通过一个mapper接口操作， （有几张表就有几个mapper接口）
      具体的sql语句写在映射文件中
     */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     */
    List<User> getUsers();
}
