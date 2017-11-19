package cn.tenement.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunbin on 2017/9/1.
 */
public class category {
    private int id;
    private String text;
    private List<category> children=new ArrayList<category>();
    public final   String iconCls="icon-print";
    private two attributes;
  private String url;
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


    public List<category> getChildren() {
        return children;
    }

    public void setChildren(List<category> children) {
        this.children = children;
    }




    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public two getAttributes() {
        return attributes;
    }

    public void setAttributes(two attributes) {
        this.attributes = attributes;
    }
}
