package cn.tenement.Entity;

import java.util.List;

/**
 * Created by sunbin on 2017/9/1.
 */
public class thrr {
    private int id;
    private String text;
    private List<two> children;

    private int cid;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<two> getChildren() {
        return children;
    }

    public void setChildren(List<two> children) {
        this.children = children;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
