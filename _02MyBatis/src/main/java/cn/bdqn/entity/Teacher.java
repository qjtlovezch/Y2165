package cn.bdqn.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/7/16.
 */
public class Teacher {
    private Integer tid;
    private String tname;
    private List<Student>ttt;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", ttt=" + ttt +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Student> getTtt() {
        return ttt;
    }

    public void setTtt(List<Student> ttt) {
        this.ttt = ttt;
    }
}
