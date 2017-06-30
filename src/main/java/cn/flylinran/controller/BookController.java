package cn.flylinran.controller;

import cn.flylinran.domain.Book;
import cn.flylinran.domain.Category;
import cn.flylinran.properties.AuthorProperties;
import cn.flylinran.service.BookService;
import cn.flylinran.service.CategoryService;
import cn.flylinran.vo.Msg;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
    @Resource
    private CategoryService categoryService;
    @Resource
    private AuthorProperties authorProperties;

    @GetMapping
    public Msg about() {
        return Msg.success().add("authorInfo", authorProperties);
    }

    @GetMapping("/book")
    public Msg bookList(@RequestParam(defaultValue = "0") Integer pageNum,
                        @RequestParam(defaultValue = "6") Integer pageSize) {
        Map<String, Object> bookInfo = bookService.findAllBookInfo(pageNum, pageSize);
        return Msg.success().add("bookInfo", bookInfo);
    }

    @GetMapping("/book/{id}")
    public Msg bookDetail(@PathVariable Integer id) {
        return Msg.success().add("book", bookService.findById(id));
    }

    @PostMapping("/book")
    public Msg add(@Valid Book book, BindingResult result) {
        if (result.hasErrors() || result.hasFieldErrors()) {
            return Msg.fail().setMessage(result.getFieldError().getDefaultMessage());
        }
        return Msg.success().add("detail", bookService.save(book));
    }

    @DeleteMapping("/book/{id}")
    public Msg del(@PathVariable Integer id) {
        return bookService.deleteById(id) ? Msg.success() : Msg.fail();
    }

    @PutMapping("/book")
    public Msg update(@RequestBody Book book) {
        return bookService.update(book) ? Msg.success().setMessage("OK") : Msg.fail();
    }

    @GetMapping("/category")
    public Msg categoryList() {
        List<Category> categories = categoryService.findAll();
        return Msg.success().add("categories", categories);
    }

    @GetMapping("/category/{id}")
    public Msg categoryDetail(@PathVariable Integer id) {
        return Msg.success().add("", categoryService.findById(id));
    }
}
