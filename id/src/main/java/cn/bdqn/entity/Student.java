package cn.bdqn.entity;

/**
 * Created by QiuShao on 2017/8/25.
 */
public class Student {
    //学号
    private Integer sid;
    //姓名
    private String name;
    //年龄
    private Integer age;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
