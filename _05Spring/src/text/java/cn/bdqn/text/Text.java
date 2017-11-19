package cn.bdqn.text;

import cn.bdqn.aop02.entity.User;

import cn.bdqn.aop.service.IUserBiz;
import cn.bdqn.aop02.service.IUserService;
import cn.bdqn.aop03.Somese;
import cn.bdqn.cglibpo.Userservice;
import cn.bdqn.jdkpro.IUserDAO;
import cn.bdqn.jdkpro.UserDAOImpl;
import cn.bdqn.jie.Student01;
import cn.bdqn.printer.print.Printer;
import cn.bdqn.service.HappyService;
import cn.bdqn.spring09aop01.SomeService;

import cn.bdqn.spring15.ISomeService1;

import cn.bdqn.spring18.ISomeService;

import cn.bdqn.spring19.service.IBookService;
import cn.bdqn.spring20.cn.bdqn.entity.StockException;
import cn.bdqn.spring20.cn.bdqn.service.IAccountService;
import cn.bdqn.spring21.entity.Book;
import cn.bdqn.spring21.service.IBookSrvice;
import cn.bdqn.staticp.Psubject;
import cn.bdqn.staticp.ReSubject;
import cn.bdqn.staticp.Subject;
import cn.bdqn.zhu.MyCollection;
import cn.bdqn.zhu.Student;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * Created by QiuShao on 2017/7/23.
 */

public class Text {
    /*spring整合MyBatis*/
    @Test
    public void test00(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring19.xml");
        IBookSrvice service = (IBookSrvice) ctx.getBean("bookService");
        Book book= new Book();
        book.setBookName("aaa");
        book.setBookPrice(1);
        service.addbook(book);
    }
    /*事务*/
    @Test
    public void test22(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring18.xml");
        IAccountService service = (IAccountService) ctx.getBean("accountService");
        try {
            service.buyStock(6,2,1,2000);
        } catch (StockException e) {
            e.printStackTrace();
        }
    }
    // jdbctemplate
   /* @Test
    public void test21(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring17.xml");
        IBookService service = (IBookService) ctx.getBean("bookService");
        List<Book> list = service.findAll();
        for (Book item:list) {
            System.out.println(item.getBookname());
        }
    }*/
    //aspectj xml
    @Test
    public void test20(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring16.xml");
        ISomeService service = (ISomeService) ctx.getBean("someService");
        service.doSome();
        service.dade();
    }
    // aspectj 注解
   /* @Test
    public void test011(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring15.xml");
        ISomeService service = (ISomeService) ctx.getBean("someService");
        service.delete();
        service.insert();
        service.update();
        service.select();

    }*/

    // BeanName自动代理生成器
    @Test
    public void test10(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring14.xml");
        ISomeService service = (ISomeService) ctx.getBean("someService");
        service.doSome();
        service.dade();
    }
    /*Advisor自动代理生成器*/
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring13.xml");
        ISomeService service = (ISomeService) ctx.getBean("someService");
        ISomeService1 service1 = (ISomeService1) ctx.getBean("someService1");
        service.doSome();
        service.dade();
        service1.doSome();
        service1.dade();
    }

    /*正则   顾问*/
    @Test
    public void test09(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring12.xml");
        ISomeService service = (ISomeService) ctx.getBean("proxyService");
        service.doSome();
        service.dade();
    }
    /*名称匹配方法顾问*/
    @Test
    public void test08(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring11.xml");
        ISomeService service = (ISomeService) ctx.getBean("proxyService");
        service.doSome();
        service.dade();
    }
    @Test
    // 异常增强
    public void test07(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring10aop04.xml");
        ISomeService service = (ISomeService) ctx.getBean("proxyService");
        service.doSome();
    }

    @Test
    // 环绕增强
    public void test06(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring09aop03.xml");
        ISomeService service = (ISomeService) ctx.getBean("proxyService");
        service.doSome();
    }

    @Test
    // 后置增强
    public void test05(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring08aop02.xml");
        ISomeService service = (ISomeService) ctx.getBean("proxyService");
        service.doSome();
    }

    @Test
    // 前置增强
    public void test04(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextspring07aop01.xml");
        SomeService service = (SomeService) ctx.getBean("proxyService");
        service.doSome();
    }
    /*cglib动态代理*/
    @Test
    public void test14(){
        final Userservice servive=new Userservice();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(servive.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开启");
                methodProxy.invoke(servive,objects);
                return null;
            }
        });
       /* enhancer.setCallback(new org.springframework.cglib.proxy.InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("开启");
                method.invoke(servive,objects);
                return null;
            }
        });*/
        Userservice aa =(Userservice) enhancer.create();
        aa.delete();
    }
    //动态代理
    @Test
    public void test13(){
       final IUserDAO dao=new UserDAOImpl();
       IUserDAO pp=(IUserDAO) Proxy.newProxyInstance(dao.getClass().getClassLoader(), dao.getClass().getInterfaces(), new InvocationHandler() {
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               System.out.println("开启");
               method.invoke(dao,args);
               return null;
           }
       });
       pp.add();
       pp.edit();
    }

    //静态代理
    @Test
    public void test12(){
        Subject subject=new ReSubject();
        Psubject psubject=new Psubject();
        psubject.setReSubject(subject);
        psubject.add();
    }

    /*注解 di*/
    @Test
    public void test11() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextjie.xml");
        Student01 aa = (Student01)cxt.getBean("student01");
        System.out.println(aa);
    }
    /*properties*/
    @Test
    public void tesst10() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextdixml.xml");
        MyCollection aa = (MyCollection)cxt.getBean("properties");
        System.out.println(aa.getProperties());
    }

    /*Map*/
    @Test
    public void tesst09() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextdixml.xml");
        MyCollection aa = (MyCollection)cxt.getBean("map");
        System.out.println(aa.getMap());
    }
    /*set*/
    @Test
    public void tesst08() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextdixml.xml");
        MyCollection aa = (MyCollection)cxt.getBean("set");
        System.out.println(aa.getSet());
    }
    /*List*/
    @Test
    public void tesst07() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextdixml.xml");
        MyCollection aa = (MyCollection)cxt.getBean("list");
        System.out.println(aa.getList());
    }
    /*Array*/
    @Test
    public void tesst06() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextdixml.xml");
        MyCollection aa = (MyCollection)cxt.getBean("array");
        System.out.println(aa.getArray()[0]);
    }

    /*构造注入  xml di*/
    @Test
    public void tesst05() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextdixml.xml");
        Student stu = (Student)cxt.getBean("stu");
        System.out.println(stu);
    }

    /*aop*/
    @Test
    public void tesst04() {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContextaop.xml");
        IUserService service =(IUserService) cxt.getBean("service");
        User user=new User();
        service.save2(user);
    }

    /*aop*//*
    @Test
    public void tesst03() {

        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserBiz service =(IUserBiz) cxt.getBean("userService");
        User user=new User();
        user.setUserName("aaa");
        service.seav(user);
    }*/

    @Test
    //打印机
    public void test02(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Printer pp=  (Printer)ctx.getBean("pinter");
        pp.print();
    }

    @Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        HappyService service=(HappyService)ac.getBean("happyService");
        service.work();
    }
}
