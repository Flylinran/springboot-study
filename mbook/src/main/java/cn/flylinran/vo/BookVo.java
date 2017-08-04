package cn.flylinran.vo;

import cn.flylinran.entity.Book;
import com.alibaba.fastjson.JSONObject;

/**
 * author: Flyli
 * date: 2017/6/30
 * description:
 */
public class BookVo extends Book {
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
