package cn.flylinran.repository;

import cn.flylinran.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    /**
     * 通过uid查找图书
     *
     * @param uid
     * @return
     */
    Book findBookByUid(String uid);

    /**
     * 通过uid查删除图书
     *
     * @param uid
     * @return
     */
    boolean deleteBookByUid(String uid);
}
