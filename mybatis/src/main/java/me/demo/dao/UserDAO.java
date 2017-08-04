package me.demo.dao;

import me.demo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * author: Flyli
 * date: 2017/7/23
 * description:
 */
public interface UserDAO {
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where id = #{id}")
    User findById(long id);
}
