package me.demo.controller;

import com.github.pagehelper.PageInfo;
import me.demo.entity.User;
import me.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: Flyli
 * date: 2017/7/23
 * description:
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user")
    public List<User> list() {
        return userService.findAll();
    }

    @GetMapping("/userByPage")
    public PageInfo<User> listByPage(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                     @RequestParam(required = false, defaultValue = "6") int pageSize) {
        return userService.findPage(pageNum, pageSize);
    }

    @GetMapping("/user/{id}")
    public User getById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
