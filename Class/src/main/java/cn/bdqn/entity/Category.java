package cn.bdqn.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
public class Category implements Serializable{
    private Integer cid;
    private String cname;
    private  Integer pid;
    private  Map<Integer,Category> map=new HashMap<Integer, Category>();
    /*//植入自己的一个泛型*/
    private List<Category> cates=new ArrayList<Category>();


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

    public List<Category> getCates() {
        return cates;
    }

    public void setCates(List<Category> cates) {
        this.cates = cates;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Map<Integer, Category> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Category> map) {
        this.map = map;
    }
}
