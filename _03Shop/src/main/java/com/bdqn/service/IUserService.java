package com.bdqn.service;


import com.bdqn.pojo.User;
import com.bdqn.pojo.User_voew;
import com.bdqn.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 王 on 2017/7/31.
 */

public interface IUserService {

    public boolean add(User user);




    public int Login(@Param("n") String n, @Param("p") String p);
    //查询用户列表
    public List<User> setUser();
    public User getall(int id);

    //修改用户
    public int updateUser(User id);
    //添加用户
    public int addNewUser(User_voew user);
  //模糊查询
    public List<User> setUserAll(String userName);
    public int count();


    //2.获取总记录数
    public int getTotalCount();
    //3.获取单页数据
    public PageUtil getOnePageData(int pageIndex, int pageSize);

    public  int updatePwd(User id);










    public List<User>GetAllUserList(@Param("pageSize") int pageSize, @Param("pageIndex") int pageIndex);


    public List<User> setUsers(String name);

    public int delId(int id);



    //4.获取带条件的总记录数
    public int getTotalCountByUserName(String userName);

    //4.模糊查询
    public PageUtil getOnePageData(int pageIndex, int pageSize, User info);
    public List<User> excelUser();

}
