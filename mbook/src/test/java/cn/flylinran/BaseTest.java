package cn.flylinran;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author: Flyli
 * date: 2017/7/2
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"dev"})
//@Transactional
public class BaseTest {
    @Value("${logging.file}")
    private String path;

    @Test
    public void test() {
        System.out.println(path);
    }
}
