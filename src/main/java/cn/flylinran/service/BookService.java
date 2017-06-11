package cn.flylinran.service;

import cn.flylinran.domain.Book;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * author: huzunrong
 * date: 2017/6/7
 * description:
 * version: 1.0
 */
public interface BookService {
    List<Book> findAll() throws Exception;

    Page<Book> findPage(Integer pn, Integer pageSize) throws Exception;

    Book findByUid(String uid) throws Exception;

    boolean save(Book book) throws Exception;

    boolean update(Book book) throws Exception;

    boolean deleteByUid(String uid) throws Exception;

    boolean delete(Book book) throws Exception;
}
