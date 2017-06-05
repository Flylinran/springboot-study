package cn.flylinran.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.flylinran.vo.Msg;

import java.util.concurrent.atomic.AtomicLong;

/**
 * author: huzunrong
 * date: 2017/6/5
 * description: HelloController
 * version: 1.0
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping
    public String home() {
        return "Hello World! - 你好!";
    }

    @RequestMapping("/greeting")
    public Msg greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return Msg.success().add("counter", counter.incrementAndGet()).add("msg",
                String.format(template, name));
    }

    @RequestMapping("/getFastjson")
    public String getFastjson(@RequestParam(value = "name", defaultValue = "World") String name) {
        Msg msg = Msg.success().add("counter", counter.incrementAndGet()).add("msg",
                String.format(template, name));
        return JSONObject.toJSONString(msg);
    }

}
