package cn.bdqn.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


public class Houseinfo {
    private Integer houseid;
    private String housedesc;
    private Integer typeid;
    private String  monthlyrent;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date publishdate;

    private Housetype housetypes;

    public Housetype getHousetypes() {
        return housetypes;
    }

    public void setHousetypes(Housetype housetypes) {
        this.housetypes = housetypes;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public String getHousedesc() {
        return housedesc;
    }

    public void setHousedesc(String housedesc) {
        this.housedesc = housedesc;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getMonthlyrent() {
        return monthlyrent;
    }

    public void setMonthlyrent(String monthlyrent) {
        this.monthlyrent = monthlyrent;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }
}
