package cn.bdqn.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 王 on 2017/7/23.
 */
public class LoggerBefore implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("------------------------");
    }
}
