package cn.bdqn.spring10afterreturingadvice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Happy on 2017-07-30.
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("===========after================");
    }
}
