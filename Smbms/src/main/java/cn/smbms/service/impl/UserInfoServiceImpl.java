package cn.smbms.service.impl;

import cn.smbms.dao.IUserInfoDAO;
import cn.smbms.entity.UserInfo;
import cn.smbms.service.IUserInfoService;
import cn.smbms.uttil.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QiuShao on 2017/8/21.
 */
@Service("userService")
public class UserInfoServiceImpl implements IUserInfoService {
    @Resource(name = "IUserInfoDAO")

    IUserInfoDAO userInfoDAO;

    public IUserInfoDAO getUserInfoDAO() {
        return userInfoDAO;
    }

    public void setUserInfoDAO(IUserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    public UserInfo isLogin(UserInfo info) {
        return userInfoDAO.isLogin(info);
    }

    public List<UserInfo> list() {
        return userInfoDAO.list();
    }

    public int delId(int id) {
        return userInfoDAO.delId(id);
    }

    public List<UserInfo> useridlist(int id) {
        return userInfoDAO.useridlist(id);
    }


    public int useradd(UserInfo user) {
        return userInfoDAO.useradd(user);
    }

    public UserInfo getall(int id) {
        return userInfoDAO.getall(id);
    }

    public int updateUser(UserInfo id) {
        return userInfoDAO.updateUser(id);
    }

    public List<UserInfo> GetAllUserList(@Param("pageSize") int pageSize, @Param("pageIndex") int pageIndex) {
        return userInfoDAO.GetAllUserList(pageSize,pageIndex);
    }

    public int count() {
        return userInfoDAO.count();
    }

    public int getTotalCount() {
        return userInfoDAO.getTotalCount();
    }

    public PageUtil getOnePageData(int pageIndex, int pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);

        PageUtil page=new PageUtil(); //实例化一个PageUtil对象
        page.setPageSize(pageSize); //给PageUtil属性赋值
        page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值
        //
        int totalCount = userInfoDAO.getTotalCount();
        page.setTotalRecords(totalCount);

        int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
        page.setTotalPages(totalPages);
        //为什么dao层方法的入参我写成map？？？
        List<UserInfo> list = userInfoDAO.getOnePageData(map);
        page.setList(list);
        return page;
    }
   //.获取一页用户数据 模糊查询
   //3.获取一页用户数据 模糊查询
   public PageUtil getOnePageData(int pageIndex,int pageSize,UserInfo info) {

       Map<String,Object> map=new HashMap<String,Object>();
       map.put("pageIndex",pageIndex*pageSize);
       map.put("pageSize",pageSize);
       map.put("userName",info.getUserName());

       PageUtil page=new PageUtil(); //实例化一个PageUtil对象

       page.setPageSize(pageSize); //给PageUtil属性赋值
       page.setPageIndex(pageIndex);//给PageUtil的pageIndex赋值
       //

       page.setTotalRecords(userInfoDAO.getTotalCountByUserName(info.getUserName()));

       int totalPages=page.getTotalRecords()%page.getPageSize()==0?page.getTotalRecords()/page.getPageSize():page.getTotalRecords()/page.getPageSize()+1;
       page.setTotalPages(totalPages);
       //为什么dao层方法的入参我写成map？？？
       List<UserInfo> list = userInfoDAO.getOnePageDataCondition(map);
       page.setList(list);
       return page;
   }

    public int getTotalCountByUserName(String userName) {
        return userInfoDAO.getTotalCountByUserName(userName);
    }

    public int updatePwd(UserInfo id) {
        return userInfoDAO.updatePwd(id);
    }

    public List<UserInfo> excelUser() {
        return userInfoDAO.excelUser();
    }


}
