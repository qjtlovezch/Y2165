package cn.blog.entity;

/**
 * Created by Happy on 2017-07-02.
 * 博客实体
 */
public class BlogInfo {
     private  Integer blogId;
     private String blogAuthor;
     private String blogAddress;
     private Boolean blogDel;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogAddress() {
        return blogAddress;
    }

    public void setBlogAddress(String blogAddress) {
        this.blogAddress = blogAddress;
    }

    public Boolean getBlogDel() {
        return blogDel;
    }

    public void setBlogDel(Boolean blogDel) {
        this.blogDel = blogDel;
    }
}
