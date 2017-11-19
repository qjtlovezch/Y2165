package cn.blog.dao.iimpl;

import cn.blog.dao.BaseDao;
import cn.blog.dao.IUserInfoDAO;
import cn.blog.entity.UserInfo;
import org.junit.Test;


import java.sql.ResultSet;

/**
 * Created by Happy on 2017-06-30.
 */
public class UserInfoDAOImpl extends BaseDao implements IUserInfoDAO {
   @Test

   public void testIsLogin(){
       UserInfo info=new UserInfo();
       info.setUserName("qjt");

       info.setUserPwd("123456");
       try {
           boolean flag = isLogin(info);
           System.out.println(flag);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }


    public boolean isLogin(UserInfo info) throws Exception {
        boolean flag = false;



        //根据用户名和密码查看复合条件的记录有几条》》》》》》》》》》》》》》
        String  sql="select count(*) from userinfo where userName=? and UserPwd=?";

        Object[] paras={info.getUserName(),info.getUserPwd()};
        ResultSet rs = executeQuery(sql, paras);
        if (rs.next()){
            int count=rs.getInt(1);
            if (count>0){
                flag=true;
            }
        }
        return flag;
    }

}
