package cn.flylinran.service;

import cn.flylinran.domain.Book;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * author: huzunrong
 * date: 2017/6/7
 * description:
 * version: 1.0
 */
public interface BookService {

    Page<Book> findPage(Integer pn, Integer pageSize);

    Book findById(Integer id);

    Map<String, Object> findAllBookInfo(Integer pageNum, Integer pageSize);

    Book save(Book book);

    boolean update(Book book);

    boolean deleteById(Integer id);

}
