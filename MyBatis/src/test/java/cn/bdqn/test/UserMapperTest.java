package cn.bdqn.test;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.entity.User;
import cn.bdqn.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QiuShao on 2017/7/13.
 */
public class UserMapperTest {

    /*if-trim 查询*/
    @Test
    public void testall(){
        SqlSession session= MybatisUtil.getSql();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User use=new User();
        use.setUserName("aaa");
        use.setUserPassword("1232");
        List<User> list=mapper.getUserList(use);
        for (User info:list) {
            System.out.println(info.getUserName());
        }
    }
    /*if-trim 修改*/
    @Test
    public void testMod(){
        SqlSession session= MybatisUtil.getSql();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=new User();
        user.setUserName("aaa");
        user.setUserPassword("1232");
        user.setId(1);
        int aa=mapper.mod(user);
        System.out.println(aa);
        session.commit();
        session.close();
    }
    /*if-set 修改*/
    @Test
    public void testModify(){
        SqlSession session= MybatisUtil.getSql();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user=new User();
        user.setUserName("aa");
        user.setUserPassword("123");
        user.setId(1);
        int aa=mapper.modify(user);
        System.out.println(aa);
        session.commit();
        session.close();
    }

}
