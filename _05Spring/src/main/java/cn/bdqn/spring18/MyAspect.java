package cn.bdqn.spring18;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.sql.rowset.JoinRowSet;

/**
 * Created by QiuShao on 2017/8/2.
 */
public class MyAspect {

    //前置增强
    public void before(){
        System.out.println("=====before========");
    }
    //后置增强
    public void afterReturing(){
        System.out.println("=====after========");
    }
    //后置增强   目标方法的返回值
    public void afterReturing(String result){
        System.out.println("=====后置通知方法 result========"+result);
    }
    //环绕通知
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("目标方法执行前执行");
        Object result = pjp.proceed();
        System.out.println("目标方法执行后执行");
        String temp=null;
        if (result!=null) {
            temp = (String) result;
            temp=temp.toUpperCase();
        }
        return temp;
    }
    //异常通知
    public void afterThrowing(){
        System.out.println("异常通知");
    }
    //异常通知
    public void afterThrowing(Exception ex){
        System.out.println("异常通知 ex="+ex.getMessage());
    }

    //最终通知
    public void after(){
        System.out.println("最终通知");
    }

}
