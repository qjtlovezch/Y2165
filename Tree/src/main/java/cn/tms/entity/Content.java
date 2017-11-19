package cn.tms.entity;

import java.util.*;

/**
 * Created by 123 on 2017/11/07.
 */

public class Content {
    private String syscode;
    private Integer columncode;
    private String columnname;
    private Integer sort;
    private String parentcode;
    private Integer status;
    private String url;
    private ScriptProperties attributes=new ScriptProperties();

    private String remark;

    private List<Content> children = new ArrayList<Content>();

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "content{" +
                "syscode='" + syscode + '\'' +
                ", columncode=" + columncode +
                ", columnname='" + columnname + '\'' +
                ", sort=" + sort +
                ", parentcode='" + parentcode + '\'' +
                ", status=" + status +
                ", url='" + url + '\'' +
                ", attributes=" + attributes +
                ", remark='" + remark + '\'' +
                ", children=" + children +
                '}';
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ScriptProperties getAttributes() {
        return attributes;
    }

    public void setAttributes(ScriptProperties attributes) {
        this.attributes = attributes;
    }

    public List<Content> getChildren() {
        return children;
    }

    public void setChildren(List<Content> children) {
        this.children = children;
    }

    public String getSyscode() {
        return syscode;
    }

    public void setSyscode(String syscode) {
        this.syscode = syscode;
    }

    public Integer getColumncode() {
        return columncode;
    }

    public void setColumncode(Integer columncode) {
        this.columncode = columncode;
    }

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}
