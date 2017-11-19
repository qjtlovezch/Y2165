package cn.bdqn.entity;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class User {
    private Integer uid;
    private String uname;
    private int upwd;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUpwd() {
        return upwd;
    }

    public void setUpwd(int upwd) {
        this.upwd = upwd;
    }
}
