package com.bdqn.util;


import com.bdqn.pojo.User;

import java.util.List;

/**
 * Created by Happy on 2017-08-23.
 */
public class PageUtil {
    private Integer pageSize; //每页显示记录数
    private Integer pageIndex;  //当前页码
    private Integer totalRecords; //总记录数
    private Integer totalPages; //总页数
    private List<User> list; //数据

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
}
