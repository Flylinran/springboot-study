package me.demo.service;

import com.github.pagehelper.PageInfo;
import me.demo.entity.User;

import java.util.List;

/**
 * author: Flyli
 * date: 2017/7/23
 * description:
 */
public interface UserService {
    PageInfo<User> findPage(int pageNum, int pageSize);

    List<User> findAll();

    User findById(long id);
}
