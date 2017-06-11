package cn.flylinran.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * author: huzunrong
 * date: 2017/6/6
 * description:
 * version: 1.0
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 32, max = 32, message = "uid长度不符合要求")
    @NotBlank(message = "uid不能为空")
    private String uid;

    @Size(min = 32, max = 32, message = "uid长度不符合要求")
    @NotBlank(message = "categoryUid不能为空")
    private String categoryUid;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotBlank(message = "author不能为空")
    private String author;

    @Min(value = 1, message = "数量必须大于0")
    @Column(nullable = false)
    private Integer price;

    private Integer stock;

    @NotNull
    private String description;

    private Date createTime = new Date();

    private Date updateTime = new Date();

    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getCategoryUid() {
        return categoryUid;
    }

    public void setCategoryUid(String categoryUid) {
        this.categoryUid = categoryUid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", categoryUid='" + categoryUid + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
