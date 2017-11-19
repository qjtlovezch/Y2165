package cn.bdqn.spring11methodinterceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Happy on 2017-07-30.
 */
public class MyMethodInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before");
        methodInvocation.proceed();
        System.out.println("after");
        return null;
    }
}
