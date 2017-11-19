package cn.bdqn.spring18;

/**
 * Created by Happy on 2017-07-30.
 */
public class SomeService implements ISomeService {
    //核心业务
    public void doSome(){
        System.out.println("我们都要找到Java开发工作，薪资6,7,8,9,10K");
    }

    public void dade() {
        //异常
        //int sun=5/0;
        System.out.println("++++++++++++++de+++++++++++++");
    }

}
