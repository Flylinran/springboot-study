package config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * author: huzunrong
 * date: 2017/6/5
 * description: 配置
 * version: 1.0
 */
@SpringBootApplication
@ComponentScan("controller")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
