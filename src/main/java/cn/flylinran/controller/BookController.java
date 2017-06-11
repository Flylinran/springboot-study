package cn.flylinran.controller;

import cn.flylinran.repository.CategoryRepository;
import cn.flylinran.domain.Book;
import cn.flylinran.domain.Category;
import cn.flylinran.domain.Msg;
import cn.flylinran.service.BookService;
import cn.flylinran.utils.UIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
@RestController
public class BookController {

    @Resource
    private BookService bookService;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/book")
    public Msg bookList(@RequestParam(defaultValue = "0") Integer pn,
                        @RequestParam(defaultValue = "7") Integer pageSize,
                        @RequestParam(defaultValue = "5") Integer navigatePages) throws Exception {

        Page<Book> bookPage = bookService.findPage(pn, pageSize);

        return Msg.success().add("page", bookPage);
    }

    @GetMapping("/book/{uid}")
    public Msg bookDetail(@PathVariable String uid) throws Exception {
        return Msg.success().add("book", bookService.findByUid(uid));
    }

    @PostMapping("/book")
    public Msg add(@Valid Book book, BindingResult result) throws Exception {
        if (result.hasErrors() || result.hasFieldErrors()) {
            System.out.println(result.getFieldError().getDefaultMessage());
            return Msg.fail().setMessage(result.getFieldError().getDefaultMessage());
        }
        return Msg.success().add("detail", bookService.save(book));
    }

    @DeleteMapping("/book/{uid}")
    public Msg del(@PathVariable String uid) throws Exception {
        return bookService.deleteByUid(uid) ? Msg.success() : Msg.fail();
    }

    @PutMapping("/book/{id}")
    public Msg update(@PathVariable String id,
                      @RequestBody Book book) throws Exception {
        book.setUid(UIDUtil.getRandomUID());
        book.setUpdateTime(new Date());
        book.setDeleted(0);
        bookService.save(book);

        return Msg.success().setMessage("OK");
    }

    @GetMapping("/category")
    public Msg categoryList() {
        List<Category> categories = categoryRepository.findAll();
        return Msg.success().add("categories", categories);
    }

    @GetMapping("/category/{uid}")
    public Msg categoryDetail(@PathVariable String uid) {
        return Msg.success().add("", categoryRepository.findCategoryByUid(uid));
    }
}
