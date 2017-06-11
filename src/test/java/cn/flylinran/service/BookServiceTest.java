package cn.flylinran.service;

import cn.flylinran.domain.Book;
import cn.flylinran.utils.UIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * author: Flyli
 * date: 2017/6/8 23:25
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class BookServiceTest {

    @Resource
    private BookService bookService;

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findPage() throws Exception {

    }

    @Test
    public void findByUid() throws Exception {
    }

    @Test
    public void save() throws Exception {
        for (int i = 0; i < 50; i++) {
            Book book = new Book();
            book.setUid(UIDUtil.getRandomUID());
            book.setCategoryUid(UIDUtil.getRandomUID());
            book.setName("书名" + (i + 1));
            book.setAuthor("作者" + (i + 1));
            book.setDescription("描述" + (i + 1));
            book.setPrice(-1);
            book.setStock(20);
            Assert.assertTrue("插入失败", bookService.save(book));
        }
    }

    @Test
    public void update() throws Exception {
        Book book = bookService.findByUid("6533137e21db473abf92cfe3e332dea1");
        book.setUpdateTime(new Date());
        book.setStock(null);
        Assert.assertTrue("更新失败", bookService.save(book));
    }

    @Test
    public void deleteByUid() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

}