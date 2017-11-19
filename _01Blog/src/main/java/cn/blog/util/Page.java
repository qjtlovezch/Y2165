package cn.blog.util;

import cn.blog.entity.BlogInfo;

import java.util.List;

/**
 * Created by QiuShao on 2017/7/3.
 */
public class Page {
    //当前页
    private int pageIndex;
    //页面记录数
    private int pageSize;
    //本页显示的真实数据
    private List<BlogInfo> bloglist;

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

    public List<BlogInfo> getBloglist() {
        return bloglist;
    }

    public void setBloglist(List<BlogInfo> bloglist) {
        this.bloglist = bloglist;
    }

    public int getTotapages() {
        return totapages;
    }

    public void setTotapages(int totapages) {
        this.totapages = totapages;
    }


}
