package cn.bdqn.entity;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class Student {
    private Integer sid;
    private String sName;
    private int score;
    private Class cid;

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", score=" + score +
                ", cid=" + cid +
                '}';
    }

    public Class getCid() {
        return cid;
    }

    public void setCid(Class cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
