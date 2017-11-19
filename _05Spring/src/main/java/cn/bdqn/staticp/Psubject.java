package cn.bdqn.staticp;

/**
 * Created by QiuShao on 2017/7/30.
 */
public class Psubject implements Subject {

    private Subject reSubject;

    public Subject getReSubject() {
        return reSubject;
    }

    public void setReSubject(Subject reSubject) {
        this.reSubject = reSubject;
    }

    public String add() {
        System.out.println("开启！");
        return reSubject.add();
    }
}
