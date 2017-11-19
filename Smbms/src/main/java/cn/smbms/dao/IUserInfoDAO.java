package cn.smbms.dao;

import cn.smbms.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by QiuShao on 2017/8/21.
 */
public interface IUserInfoDAO {
    //登录的方法
    public UserInfo isLogin(UserInfo info);

    //用户列表
    public List<UserInfo> list();

    //删除用户
    public int delId(int id);

    //根据id查询
    public List<UserInfo> useridlist(int id);



    //添加用户
    public int useradd(UserInfo user);

    public UserInfo getall(int id);
    //修改用户
    public int updateUser(UserInfo id);

    public List<UserInfo>GetAllUserList(@Param("pageSize") int pageSize, @Param("pageIndex") int pageIndex);

    //查询记录数
    public int count();

    //2.获取总记录数
    public int getTotalCount();
    //3.获取单页数据
    public List<UserInfo> getOnePageData(Map<String, Object> map);


    public List<UserInfo> getOnePageDataCondition(Map<String, Object> map);
    //4.获取带条件的总记录数
    public int getTotalCountByUserName(String userName);

    public  int updatePwd(UserInfo id);
    public List<UserInfo> excelUser();

}
