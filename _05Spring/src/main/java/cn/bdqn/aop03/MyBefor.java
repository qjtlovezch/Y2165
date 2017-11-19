package cn.bdqn.aop03;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by QiuShao on 2017/7/30.
 */
public class MyBefor implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("好好学习，天天线上");
    }



}
