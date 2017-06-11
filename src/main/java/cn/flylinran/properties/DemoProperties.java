package cn.flylinran.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "datasource")
public class DemoProperties {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
