package cn.flylinran.service.impl;

import cn.flylinran.vo.BookVo;
import cn.flylinran.domain.Book;
import cn.flylinran.repos.BookRepository;
import cn.flylinran.service.BookService;
import cn.flylinran.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: huzunrong
 * date: 2017/6/7
 * description:
 * version: 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;
    @Resource
    private CategoryService categoryService;

    @Override
    public Page<Book> findPage(Integer pageNum, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Map<String, Object> findAllBookInfo(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        Page<Book> page = findPage(pageNum, pageSize);
        map.put("totalPages", page.getTotalPages());
        map.put("totalPages", page.getTotalPages());
        map.put("size", page.getSize());
        map.put("number", page.getNumber());
        map.put("numberOfElements", page.getNumberOfElements());

        List<Book> bookList = page.getContent();
        List<BookVo> books = new ArrayList<>();
        bookList.parallelStream()
                .forEach(book -> {
                    BookVo bookVo = new BookVo();
                    bookVo.setId(book.getId());
                    bookVo.setUid(book.getUid());
                    bookVo.setCategoryId(book.getCategoryId());
                    bookVo.setCategoryName(categoryService.findById(book.getCategoryId()).getName());
                    bookVo.setAuthor(book.getAuthor());
                    bookVo.setDescription(book.getDescription());
                    bookVo.setName(book.getName());
                    bookVo.setPrice(book.getPrice());
                    bookVo.setStock(book.getStock());
                    bookVo.setCreateTime(book.getCreateTime());
                    bookVo.setCreateTime(book.getCreateTime());
                    bookVo.setDeleted(book.isDeleted());
                    books.add(bookVo);
                });
        map.put("books", books);

        return map;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean update(Book book) {
        return null != save(book);
    }

    @Override
    public boolean deleteById(Integer id) {
        return 1 == bookRepository.logicalDeleteById(id);
    }
}
