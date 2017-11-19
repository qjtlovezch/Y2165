package com.bdqn.service;

import com.bdqn.dao.IUserDao;
import com.bdqn.pojo.User;
import com.bdqn.pojo.User_voew;
import com.bdqn.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王 on 2017/7/31.
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

   @Resource
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }



    public boolean add(User user) {
        return false;
    }

    public int Login(@Param("n") String n, @Param("p") String p) {

        return userDao.Login(n,p);
    }

    public List<User> setUser() {
        return userDao.setUser();
    }

    public List<User> GetAllUserList(@Param("pageSize") int pageSize, @Param("pageIndex") int pageIndex) {
        return userDao.GetAllUserList(pageSize,pageIndex);
    }

    public int count() {
        return userDao.count();
    }

    public int getTotalCount() {
        return userDao.getTotalCount();
    }

    public PageUtil getOnePageData(int pageIndex, int pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);

        PageUtil page=new PageUtil(); //实例化一个PageUtil对象
        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值
        //
        int totalCount = userDao.getTotalCount();
        page.setTotalRecords(totalCount);

        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<User> list = userDao.getOnePageData(map);
        page.setList(list);
        return page;
    }

    public int updatePwd(User id) {
        return userDao.updatePwd(id);
    }


    public int getTotalCountByUserName(String userName) {
        return userDao.getTotalCountByUserName(userName);
    }

    //3.获取一页用户数据 模糊查询
    public PageUtil getOnePageData(int pageIndex,int pageSize,User info) {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
        map.put("userName",info.getUserName());

        PageUtil page=new PageUtil(); //实例化一个PageUtil对象

        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值
        //

        page.setTotalRecords(userDao.getTotalCountByUserName(info.getUserName()));

        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<User> list = userDao.getOnePageDataCondition(map);
        page.setList(list);
        return page;
    }

    public List<User> excelUser() {
        return userDao.excelUser();
    }


    public List<User> setUsers(String name) {
        return userDao.setUsers(name);
    }

    public int delId(int id) {
        return userDao.delId(id);
    }



    public User getall(int id) {
        return userDao.getall(id);
    }

    public int updateUser(User id) {
        return userDao.updateUser(id);
    }

    public int addNewUser(User_voew user) {
        return userDao.addNewUser(user);
    }

    public List<User> setUserAll(String userName) {
        return userDao.setUserAll(userName);
    }


}
