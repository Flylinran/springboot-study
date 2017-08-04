package cn.flylinran.entity;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;

/**
 * 图书类别
 */
@Entity
public class Category extends BaseEntity {

    @Length(min = 2, message = "长度不够")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
