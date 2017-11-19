package cn.bdqn.spring17;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by QiuShao on 2017/7/31.
 */
@Aspect
public class MyAspect {
    @Pointcut("execution(* *..spring17.*.*(..))")
    private void mypornt(){}
    @Pointcut("execution(* *..spring17.*.insert(..))")
    private void insert(){}
    @Pointcut("execution(* *..spring17.*.delete(..))")
    private void delete(){}
    @Pointcut("execution(* *..spring17.*.update(..))")
    private void update(){}

    @Before("insert()||delete()||update()")
    public void before(){
        System.out.println("前置增强");
    }
    /*@After("mypornt()")
    public void after(){
        System.out.println("最终");
    }*/
    /*前置增强*/
  /*  @Before(value = "execution(* *..spring17.*.*(..))")
    public void before(){
        System.out.println("前置增强");
    }*/

    /*后置增强*/
   /* @AfterReturning(value = "execution(* *..spring17.*.*(..))")
    public void after(){
        System.out.println("后置增强");
    }*/
    /*环绕增强*/
   /* @Around(value = "execution(* *..spring17.*.*(..))")
    public Object around(ProceedingJoinPoint proceed) throws Throwable {
        System.out.println("环绕前");
        Object result=proceed.proceed();
        System.out.println("环绕后");
        if(result!=null){
           return result;
            *//*String str=(String)result;
            return str.toUpperCase();*//*
        }else {
            return null;
        }
    }*/


    /*@AfterThrowing("mypornt()")
    public void throwing(){
        System.out.println("出错了！");
    }*/
}
