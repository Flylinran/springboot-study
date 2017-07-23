package cn.flylinran.controller;

import cn.flylinran.vo.Msg;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: Flyli
 * date: 2017/7/22
 * description:
 */
@RestController
@RequestMapping("/demo01")
public class DemoController01 implements EnvironmentAware {

    private String javaPath;

    @GetMapping("/")
    public Msg index() {
        return Msg.success().setMessage(javaPath);
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.err.println("JAVA_HOME -> " + environment.getProperty("JAVA_HOME"));
        javaPath = environment.getProperty("JAVA_HOME");
    }
}
