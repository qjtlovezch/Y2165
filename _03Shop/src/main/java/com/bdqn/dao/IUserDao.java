package com.bdqn.dao;

import com.bdqn.pojo.User;
import com.bdqn.pojo.User_voew;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface IUserDao {

    //获取所有用户列表
    public List<User>GetAllUserList(@Param("pageSize") int pageSize, @Param("pageIndex") int pageIndex);

    //2.获取总记录数
    public int getTotalCount();
    //3.获取单页数据
    public List<User> getOnePageData(Map<String, Object> map);





    //登录
    public int Login(@Param("n") String n, @Param("p") String p);

    //查询记录数
    public int count();

    //删除用户
    public int delId(int id);
    public User getall(int id);
    //修改用户
    public int updateUser(User id);
    //添加用户
    public int addNewUser(User_voew user);

    //模糊查询
    public List<User> setUserAll(String userName);









    //修改密码
    public  int updatePwd(User id);

    //查询用户
    public List<User> setUsers(String name);
    public List<User> setUser();
    //根据用户角色查询用户列表
    public List<User> setUser(User user);



    //模糊查询
    public List<User>getOnePageDataCondition(Map<String, Object> map);
    //4.获取带条件的总记录数
    public int getTotalCountByUserName(String userName);

       public List<User> excelUser();




}