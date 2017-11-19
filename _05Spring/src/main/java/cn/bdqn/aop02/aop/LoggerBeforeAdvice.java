package cn.bdqn.aop02.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Happy on 2017-07-24.
 */
public class LoggerBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("======我傲骄==================");
    }
}
