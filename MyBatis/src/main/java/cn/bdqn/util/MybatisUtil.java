package cn.bdqn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by QiuShao on 2017/7/9.
 */
public class MybatisUtil {
    private  static SqlSessionFactory factory;
    private static String path="Mybatis-config.xml";
    public static SqlSession getSql(){
        try {
            InputStream is= Resources.getResourceAsStream(path);
            factory=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  factory.openSession();
    }



}
