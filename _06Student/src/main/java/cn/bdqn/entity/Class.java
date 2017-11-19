package cn.bdqn.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class Class {
    private Integer cid;
    private String cName;
    private List<Student> stu=new ArrayList<Student>();

    @Override
    public String toString() {
        return "Class{" +
                "cid=" + cid +
                ", cName='" + cName + '\'' +
                ", stu=" + stu +
                '}';
    }

    public List<Student> getStu() {
        return stu;
    }

    public void setStu(List<Student> stu) {
        this.stu = stu;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
