package cn.flylinran.domain;

import com.alibaba.fastjson.JSONObject;

import javax.persistence.Entity;

/**
 * 图书类别
 */
@Entity
public class Category extends BaseEntity {

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
