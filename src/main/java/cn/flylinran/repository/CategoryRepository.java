package cn.flylinran.repository;

import cn.flylinran.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * 通过uid查找图书类别
     *
     * @param uid
     * @return
     */
    Category findCategoryByUid(String uid);
}
