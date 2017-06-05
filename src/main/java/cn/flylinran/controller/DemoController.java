package cn.flylinran.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: huzunrong
 * date: 2017/6/5
 * description:
 * version: 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/byzero")
    public void testExceptionHandler() {
        int i = 100 / 0;
    }
}
