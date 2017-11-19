package cn.tenement.Entity;

import java.util.Date;

/**
 * Created by sunbin on 2017/8/30.
 */
public class houseinfo {
private int houseid;
private String housedesc;
private int typeid;
private double monthlyrent;
private Date publishdate;
private housetype types;
private String date;
private String content;

    public int getHouseid() {
        return houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }

    public String getHousedesc() {
        return housedesc;
    }

    public void setHousedesc(String housedesc) {
        this.housedesc = housedesc;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public double getMonthlyrent() {
        return monthlyrent;
    }

    public void setMonthlyrent(double monthlyrent) {
        this.monthlyrent = monthlyrent;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public housetype getTypes() {
        return types;
    }

    public void setTypes(housetype types) {
        this.types = types;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
