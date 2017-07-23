package cn.flylinran.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    private Long id;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updateTime;
    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createTime;
    @JsonIgnore
    private boolean deleted;

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        updateTime = new Date();
        if (createTime == null) {
            createTime = new Date();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
