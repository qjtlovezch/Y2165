package cn.bdqn.spring12throwadvice;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by Happy on 2017-07-30.
 */
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("错误");
    }

}
