package cn.flylinran.service.impl;

import cn.flylinran.domain.Book;
import cn.flylinran.repository.BookRepository;
import cn.flylinran.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class BookServiceImpl implements BookService {

    @Resource
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findPage(Integer pn, Integer pageSize) {
        Pageable pageable = new PageRequest(pn, pageSize);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findByUid(String uid) {
        return bookRepository.findBookByUid(uid);
    }

    @Override
    public boolean save(Book book) {
        return null != bookRepository.save(book);
    }

    @Override
    public boolean update(Book book) {
        try {
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            System.out.println("-----------------------");
            return false;
        }
    }

    @Override
    public boolean deleteByUid(String uid) {
        return bookRepository.deleteBookByUid(uid);
    }

    @Override
    public boolean delete(Book book) {
        try {
            bookRepository.delete(book);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
