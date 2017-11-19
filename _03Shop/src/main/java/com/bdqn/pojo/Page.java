package com.bdqn.pojo;

import java.util.List;

/**
 * Created by 王 on 2017/7/3.
 */
public class Page {
    private int pageIndex;
    //页面记录数
    private int pageSize;
    //本页显示的真实数据
    private List<User> bloglist;
    private List<Provider>bloglists;

    public List<Provider> getBloglists() {
        return bloglists;
    }

    public void setBloglists(List<Provider> bloglists) {
        this.bloglists = bloglists;
    }

    //总页数
    private int totapages;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<User> getBloglist() {
        return bloglist;
    }

    public void setBloglist(List<User> bloglist) {
        this.bloglist = bloglist;
    }

    public int getTotapages() {
        return totapages;
    }

    public void setTotapages(int totapages) {
        this.totapages = totapages;
    }


}
