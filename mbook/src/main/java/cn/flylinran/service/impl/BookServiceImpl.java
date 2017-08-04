package cn.flylinran.service.impl;

import cn.flylinran.entity.Book;
import cn.flylinran.repos.BookRepository;
import cn.flylinran.service.BookService;
import cn.flylinran.service.CategoryService;
import cn.flylinran.vo.BookVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    public static final String CACHE_NAME = "book";

    @Resource
    private BookRepository bookRepository;
    @Resource
    private CategoryService categoryService;

    @Override
    public Page<Book> findPage(Integer pageNum, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        return bookRepository.findAllByDeletedFalse(pageable);
    }

    @Override
//    @Cacheable(value = CACHE_NAME, key = "#id + 'byId'")
    public Book findById(long id) {
        logger.info("info -> {}", "没有从缓存拿数据");
        return bookRepository.findOne(id);
    }

    @Override
    public Map<String, Object> findAllBookInfo(Integer pageNum, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        Page<Book> page = findPage(pageNum, pageSize);
        map.put("totalPages", page.getTotalPages());
        map.put("number", page.getNumber());
        map.put("numberOfElements", page.getNumberOfElements());
        map.put("totalElements", page.getTotalElements());

        List<Book> bookList = page.getContent();
        List<BookVo> books = new ArrayList<>();
        bookList.parallelStream()
                .forEach(book -> {
                    BookVo bookVo = new BookVo();
                    bookVo.setId(book.getId());
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

    @Transactional
    @Override
//    @CachePut("book")
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean update(Book book) {
        return null != save(book);
    }

    @Transactional
    @Override
//    @CacheEvict(value = CACHE_NAME, key = "#id + 'byId'")
    public boolean deleteById(long id) {
        return 1 == bookRepository.logicalDeleteById(id);
    }
}
