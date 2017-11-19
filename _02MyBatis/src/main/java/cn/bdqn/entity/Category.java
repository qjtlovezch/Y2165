package cn.bdqn.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/7/14.
 */
public class Category {
    private Integer cid;
    private String cname;
    private Integer pid;

    private List<Category> cates=new ArrayList<Category>();

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", pid=" + pid +
                ", cates=" + cates +
                '}';
    }

    public List<Category> getCates() {
        return cates;
    }

    public void setCates(List<Category> cates) {
        this.cates = cates;
    }



    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
