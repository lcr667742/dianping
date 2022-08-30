package com.lee.dianping.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 商家
 * @Author 61671
 * @Date 2022/8/30 14:08
 * @Version 1.0.0
 */
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商家名称
     */
    private String name;

    /**
     * 评分
     */
    private float remarkScore;

    /**
     * 禁用标识 0-否 1-是
     */
    private int disabledFlag;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
    private Date createdAt;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone ="GMT+8")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRemarkScore() {
        return remarkScore;
    }

    public void setRemarkScore(float remarkScore) {
        this.remarkScore = remarkScore;
    }

    public int getDisabledFlag() {
        return disabledFlag;
    }

    public void setDisabledFlag(int disabledFlag) {
        this.disabledFlag = disabledFlag;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Seller{" +
            "id=" + id +
            ", name=" + name +
            ", remarkScore=" + remarkScore +
            ", disabledFlag=" + disabledFlag +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
        "}";
    }
}
