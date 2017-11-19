package cn.tenement.Dao;

import cn.tenement.Entity.User;
import cn.tenement.Entity.bill;
import cn.tenement.Entity.role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Created by sunbin on 2017/8/23.
 */
public interface IUserInfoDao {

    public User login(String name, String pwd);

    public role select(int userRole);

    public List<User> list2(int pageIndex, int pageSize);

    public List<User> list(int pageIndex, int pageSize, @Param("userName") String userName);
    public int count(@Param("userName") String userName);

    public  int inserts(User bill);
    public  User selects(int id);
    public int updates(User bill);
   public List<role> rolelist();
    public int deletes(int id);
 public int insertrole(role role);
    public int roleupdates(role bill);
public int uppwd(String pwd, String pwds, int id);
    public role roles(int id);
    public int roledeletes(int id);

}
