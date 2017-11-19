package cn.bdqn.spring15;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

//前置通知
public class MyBeforeAdvise implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("=============log==================");
    }
}
