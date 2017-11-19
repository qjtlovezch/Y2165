package cn.blog.entity;

import java.util.Date;

/**
 * Created by QiuShao on 2017/7/7.
 */
public class home {
    private  Integer homeId;
    private String homeGrade;
    private String homeTeacher;
    private String homeChapter;
    private String homeContent;
    private Date homeTime;

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getHomeGrade() {
        return homeGrade;
    }

    public void setHomeGrade(String homeGrade) {
        this.homeGrade = homeGrade;
    }

    public String getHomeTeacher() {
        return homeTeacher;
    }

    public void setHomeTeacher(String homeTeacher) {
        this.homeTeacher = homeTeacher;
    }

    public String getHomeChapter() {
        return homeChapter;
    }

    public void setHomeChapter(String homeChapter) {
        this.homeChapter = homeChapter;
    }

    public String getHomeContent() {
        return homeContent;
    }

    public void setHomeContent(String homeContent) {
        this.homeContent = homeContent;
    }

    public Date getHomeTime() {
        return homeTime;
    }

    public void setHomeTime(Date homeTime) {
        this.homeTime = homeTime;
    }
}
