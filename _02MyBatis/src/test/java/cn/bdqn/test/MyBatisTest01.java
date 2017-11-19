package cn.bdqn.test;


import cn.bdqn.dao.*;
import cn.bdqn.entity.*;
import cn.bdqn.util.MybatisUtil;
import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by 邱少 on 2017/7/6.
 */
public class MyBatisTest01 {
    @Test
    public void testy(){
        SqlSession session=MybatisUtil.getSql();
        BmDAO dao=session.getMapper(BmDAO.class);
        deptt aa=dao.getNo(1);
        System.out.println(aa.getEmps());
    }
    /*增删改   二级*/
    @Test
    public void testtwoadd(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao=session.getMapper(IDeptDao.class);
        Dept dept=dao.getid(1);
        System.out.println(dept.getBlogAuthor());

        Dept d1=new Dept();
        d1.setBlogAuthor("aaaa");
        d1.setBlogAddress("aaaaa");
        dao.insert(d1);

        session.close();

        SqlSession session2=MybatisUtil.getSql();
        IDeptDao dao2=session2.getMapper(IDeptDao.class);
        System.out.println("..............................");
        Dept dept2=dao2.getid(1);
        System.out.println(dept2.getBlogAuthor());

    }

    /*二级*/
    @Test
    public void testtwo(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao=session.getMapper(IDeptDao.class);
        Dept dept=dao.getid(1);
        System.out.println(dept.getBlogAuthor());
        session.close();


        SqlSession session2=MybatisUtil.getSql();
        IDeptDao dao2=session2.getMapper(IDeptDao.class);
        System.out.println("..............................");
        Dept dept2=dao2.getid(1);
        System.out.println(dept2.getBlogAuthor());

    }
    /* 增删改 一级*/
    @Test
    public void testoneadd(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao=session.getMapper(IDeptDao.class);
        Dept dept=dao.getid(1);
        System.out.println(dept.getBlogAuthor());

        Dept d1=new Dept();
        d1.setBlogAuthor("aaaa");
        d1.setBlogAddress("aaaaa");
        dao.insert(d1);

        System.out.println("=====================================");
        Dept dept2=dao.getid(1);
        System.out.println(dept2.getBlogAuthor());

    }
    /*一级*/
    @Test
    public void testone(){
        SqlSession session=MybatisUtil.getSql();
       IDeptDao dao=session.getMapper(IDeptDao.class);
        Dept dept=dao.getid(1);
        System.out.println(dept.getBlogAuthor());

        Dept dept2=dao.getid(1);
        System.out.println(dept2.getBlogAuthor());

    }
    /* 多对多*/
    @Test
    public void testddd(){
        SqlSession session=MybatisUtil.getSql();
        ITeacher dao=session.getMapper(ITeacher.class);
        Teacher teacher=dao.geti(1);
        System.out.println(teacher.getTname());
        for (Student item:teacher.getTtt()) {
            System.out.println(item.getSname());
        }
    }
    /* 自连接*/
    @Test
    public void testz(){
        SqlSession session=MybatisUtil.getSql();
        ICategoryDAO dao=session.getMapper(ICategoryDAO.class);
        List<Category> list = dao.getabypid(1);
        for (Category item:list) {
            System.out.println(item);
        }
    }
    /* 多对一 多sql*/
    @Test
    public void testempd(){
        SqlSession session=MybatisUtil.getSql();
        IEmpDAO dao=session.getMapper(IEmpDAO.class);
        Emp emp=dao.getemp(1);
        System.out.println(emp.getEmpName());
        System.out.println(emp.getDept().getDeptName());
    }
   /* 多对一 单sql*/
   @Test
   public void testempon(){
       SqlSession session=MybatisUtil.getSql();
       IEmpDAO dao=session.getMapper(IEmpDAO.class);
       Emp emp=dao.getempon(1);
       System.out.println(emp.getEmpName());
       System.out.println(emp.getDept().getDeptName());
   }
/* 一对多 多sql */
    @Test
    public void testOneToManysql(){
        SqlSession session= MybatisUtil.getSql();
        BmDAO dao = session.getMapper(BmDAO.class);
        deptt dept = dao.getNo(1);
        System.out.println(dept.getDeptName());
        for (Emp emp:dept.getEmps()) {
            System.out.println(emp.getEmpName());
        }
        session.close();
    }
    /* 一对多 单sql */
    @Test
    public void testOneToMany(){
        SqlSession session= MybatisUtil.getSql();
        BmDAO dao = session.getMapper(BmDAO.class);
        deptt dept = dao.getEmpsByDeptNo(5);
        System.out.println(dept.getDeptName());
        for (Emp emp:dept.getEmps()) {
            System.out.println(emp.getEmpName());
        }
        session.close();
    }
    @Test
    //智能标签list<Integer>
    public void testdept(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
        List<Dept> list=new ArrayList<Dept>();
       Dept D1=new Dept();
       D1.setBlogId(1);
        Dept D2=new Dept();
        D2.setBlogId(9);
        list.add(D1);
        list.add(D2);
        List<Dept> lis=dao.findDept(list);
        for (Dept item:lis) {
            System.out.println(item.getBlogAuthor());
        }
    }
    @Test
    //智能标签list<Integer>
    public void testlist(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(9);
        List<Dept> lis=dao.findlist(list);
        for (Dept item:lis) {
            System.out.println(item.getBlogAuthor());
        }
    }
    @Test
    //智能标签choose
    public void testchoose(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
        Dept dept=new Dept();
      /* dept.setBlogAuthor("宇");
       dept.setBlogId(3);*/
        List<Dept> list = dao.findchoose(dept);
        for (Dept item:list) {
            System.out.println(item.getBlogAuthor());
        }
    }
    @Test
    //智能标签if
    public void testif(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
       Dept dept=new Dept();
       /*dept.setBlogAuthor("宇");
       dept.setBlogId(3);*/
        List<Dept> list = dao.findByIf(dept);
        for (Dept item:list) {
            System.out.println(item.getBlogAuthor());
        }
    }
    @Test
    //多添件查询索引
    public void duos(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
        List<Dept> list =dao.findsuo("王",3);
        for (Dept item:list) {
            System.out.println(item.getBlogAuthor());
        }
    }
    @Test
    //多条件查询
    public void duo(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("blogAuthor","王");
        map.put("blogId","3");
        List<Dept> list =dao.find(map);
        for (Dept item:list) {
            System.out.println(item.getBlogAuthor());
        }
    }
@Test
    //模糊查询
    public void ss(){
        SqlSession session=MybatisUtil.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
        Dept de=new Dept();
        de.setBlogAuthor("少");
        List<Dept> list=dao.findAll(de);
        for (Dept info:list) {
            System.out.println(info.getBlogAuthor());
        }
    }
    @Test
    //工具类
    public void aa(){
        MybatisUtil mb=new MybatisUtil();
        SqlSession session = mb.getSql();
        IDeptDao dao = session.getMapper(IDeptDao.class);
        Dept getid = dao.getid(1);
        System.out.println(getid.getBlogAuthor());
    }
    @Test
    //查询所有
    public void testAll() {
        //获取大配置
        String path = "Mybatis-config.xml";
        //输入流
        try {
            InputStream stream= Resources.getResourceAsStream(path);
            //sqlsession的Builder方法
            SqlSessionFactory session=new SqlSessionFactoryBuilder().build(stream);
            SqlSession sqlSession= session.openSession();
            List<Dept> list = sqlSession.selectList("getAll");
            for (Dept item:list){
                System.out.println(item.getBlogAuthor());
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //根据id查询
    public void testid() {
        //获取大配置
        String path = "Mybatis-config.xml";
        //输入流
        try {
            InputStream stream= Resources.getResourceAsStream(path);
            //sqlsession的Builder方法
            SqlSessionFactory session=new SqlSessionFactoryBuilder().build(stream);
            SqlSession sqlSession= session.openSession();
            Dept item = sqlSession.selectOne("getid",1);
            System.out.println(item.getBlogAuthor());
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testidGetMapper() {
        //获取大配置
        String path = "Mybatis-config.xml";
        //输入流
        try {
            InputStream stream= Resources.getResourceAsStream(path);
            //sqlsession的Builder方法
            SqlSessionFactory session=new SqlSessionFactoryBuilder().build(stream);
            SqlSession sqlSession= session.openSession();
            IDeptDao dao=sqlSession.getMapper(IDeptDao.class);
            Dept item=dao.getid(1);
            //Dept item = sqlSession.selectOne("getid",1);
            System.out.println(item.getBlogAuthor());
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    /*添加*/
    public void in(){
        Dept de=new Dept();
        de.setBlogAuthor("qqq");
        de.setBlogAddress("qqq");
        MybatisUtil util=new MybatisUtil();
        SqlSession session=util.getSql();
        IDeptDao dao= session.getMapper(IDeptDao.class);
        int aa=dao.insert(de);
        System.out.println(aa);
        session.commit();
        session.close();
    }

    @Test
    /*修改*/
    public void up(){
        Dept dept=new Dept();
        dept.setBlogId(162);
        dept.setBlogAuthor("sss");
        dept.setBlogAddress("sss");
        MybatisUtil util=new MybatisUtil();
        SqlSession session=util.getSql();
        IDeptDao dao= session.getMapper(IDeptDao.class);
        int aa=dao.upd(dept);
        System.out.println(aa);
        session.commit();
        session.close();
    }
    @Test
  /*  删除*/
    public void del(){
        MybatisUtil util=new MybatisUtil();
        SqlSession session=util.getSql();
        IDeptDao dao=session.getMapper(IDeptDao.class);
        int aa=dao.del(164);
         System.out.println(aa);
         session.commit();
         session.close();
    }
}
