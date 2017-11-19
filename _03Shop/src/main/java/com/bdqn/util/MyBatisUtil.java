package com.bdqn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisUtil {


    public  static SqlSession createSqlSession() throws IOException {

        InputStream is= Resources.getResourceAsStream("MyBatis-config.xml");
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);

        return  factory.openSession();
    }

     public  static  void  closeSqlSession(SqlSession sqlSession){
        if(null!=sqlSession){
            sqlSession.close();
        }
     }


}
