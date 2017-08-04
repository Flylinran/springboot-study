package cn.flylinran.repos;

import cn.flylinran.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Modifying
    @Query("UPDATE Category d SET d.deleted = true WHERE d.id =?1")
    int logicalDeleteById(Long id);
}
