package cn.bdqn.util;

import cn.bdqn.dao.IDeptDao;
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
    static String path="Mybatis-config.xml";
    static InputStream is=null;

    static {
        try {
            is= Resources.getResourceAsStream(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
    public static SqlSession  getSql(){
        return factory.openSession();
    }
}
