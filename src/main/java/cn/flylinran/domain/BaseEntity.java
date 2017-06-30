package cn.flylinran.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * author: Flyli
 * date: 2017/6/30
 * description:
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 32, max = 32, message = "uid长度不符合要求")
    @NotBlank(message = "uid不能为空")
    private String uid;
    private Date createTime = new Date();
    private Date updateTime = new Date();
    private boolean deleted;

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
