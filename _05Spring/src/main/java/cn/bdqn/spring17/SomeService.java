package cn.bdqn.spring17;

/**
 * Created by Happy on 2017-07-30.
 */
public class SomeService implements ISomeService {
    //核心业务
    public void doSome(){
        System.out.println("我们都要找到Java开发工作，薪资6,7,8,9,10K");
    }

    public String dade() {
        //int i=1/0;
        System.out.println("==================");
        return "add";
    }

    public void insert() {
        System.out.println("insert");
    }

    public void delete() {
        System.out.println("delete");

    }

    public void update() {

        System.out.println("update");
    }

    public void select() {

        System.out.println("select");
    }


}
