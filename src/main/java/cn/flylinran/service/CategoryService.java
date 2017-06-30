package cn.flylinran.service;

import cn.flylinran.domain.Category;

import java.util.List;

/**
 * author: huzunrong
 * date: 2017/6/7
 * description:
 * version: 1.0
 */
public interface CategoryService {

    List<Category> findAll();

    Category findById(Integer id);

    Category save(Category category);

    boolean update(Category category);

    boolean deleteById(Integer id);

}
