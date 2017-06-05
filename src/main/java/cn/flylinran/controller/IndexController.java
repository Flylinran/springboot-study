package cn.flylinran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author: huzunrong
 * date: 2017/6/5
 * description:
 * version: 1.0
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
