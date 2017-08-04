package cn.flylinran.service.impl;

import cn.flylinran.entity.Category;
import cn.flylinran.repos.CategoryRepository;
import cn.flylinran.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: huzunrong
 * date: 2017/6/7
 * description:
 * version: 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean update(Category category) {
        return null != save(category);
    }

    @Override
    public boolean deleteById(long id) {
        return 1 == categoryRepository.logicalDeleteById(id);
    }
}
