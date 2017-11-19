package cn.bdqn.spring20.cn.bdqn.entity;

/**
 * Created by QiuShao on 2017/8/4.
 */
public class Stock {
    private int sid;
    private String sname;
    private int count;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
