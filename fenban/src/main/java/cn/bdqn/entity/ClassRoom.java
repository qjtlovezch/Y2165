package cn.bdqn.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/11.
 */
public class ClassRoom {
    private int classesid;
    private String classesanem;



    private List<Student> stu=new ArrayList<Student>();

    public List<Student> getStu() {
        return stu;
    }

    public void setStu(List<Student> stu) {
        this.stu = stu;
    }

    public int getClassesid() {
        return classesid;
    }

    public void setClassesid(int classesid) {
        this.classesid = classesid;
    }

    public String getClassesanem() {
        return classesanem;
    }

    public void setClassesanem(String classesanem) {
        this.classesanem = classesanem;
    }
}
