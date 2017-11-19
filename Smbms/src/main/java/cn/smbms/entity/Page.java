package cn.smbms.entity;

import java.util.List;


public class Page {
    private int pageIndex;
    //页面记录数
    private int pageSize;
    //本页显示的真实数据
    private List<UserInfo> bloglist;
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

    public List<UserInfo> getBloglist() {
        return bloglist;
    }

    public void setBloglist(List<UserInfo> bloglist) {
        this.bloglist = bloglist;
    }

    public int getTotapages() {
        return totapages;
    }

    public void setTotapages(int totapages) {
        this.totapages = totapages;
    }


}
