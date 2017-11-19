package cn.bdqn.entity;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class Student {
    private int sid;
    private String sname;
    private int score;
    private ClassRoom cid;



    public ClassRoom getCid() {
        return cid;
    }

    public void setCid(ClassRoom cid) {
        this.cid = cid;
    }


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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
