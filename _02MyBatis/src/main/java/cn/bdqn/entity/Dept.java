package cn.bdqn.entity;

import java.io.Serializable;

/**
 * Created by 邱少 on 2017/7/6.
 */
public class Dept implements Serializable{

    private Integer blogId;
    private String blogAuthor;
    private String blogAddress;
    private boolean blogDel;

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

    public boolean isBlogDel() {
        return blogDel;
    }

    public void setBlogDel(boolean blogDel) {
        this.blogDel = blogDel;
    }


}
