package cn.bdqn.spring14;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Happy on 2017-07-30.
 */
//前置通知
public class MyBeforeAdvise implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("=============log==================");
    }
}
