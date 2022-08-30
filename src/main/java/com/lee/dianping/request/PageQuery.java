package com.lee.dianping.request;

/**
 * @Description 分页请求参数
 * @Author 61671
 * @Date 2022/8/30 15:17
 * @Version 1.0.0
 */
public class PageQuery {

    private Integer page = 1;

    private Integer size = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
