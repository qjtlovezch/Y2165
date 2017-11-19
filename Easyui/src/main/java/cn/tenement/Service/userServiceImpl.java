package cn.tenement.Service;

import cn.tenement.Dao.IUserInfoDao;
import cn.tenement.Entity.User;
import cn.tenement.Entity.bill;
import cn.tenement.Entity.role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunbin on 2017/8/23.
 */
@Service("userService")
public class userServiceImpl implements IuserService{
    @Resource
      IUserInfoDao user;
    public User login(String name, String pwd) {
        return user.login(name,pwd);
    }

    public role select(int userRole) {
        return user.select(userRole);
    }

    public List<User> list2(int pageIndex, int pageSize) {
        return user.list2(pageIndex,pageSize);
    }

    public List<User> list(int pageIndex, int pageSize, @Param("userName") String userName) {
        return user.list(pageIndex,pageSize,userName);
    }

    public int count(@Param("userName") String userName) {
        return user.count(userName);
    }

    public int inserts(User bill) {
        return user.inserts(bill);
    }

    public User selects(int id) {
        return user.selects(id);
    }

    public int updates(User bill) {
        return user.updates(bill);
    }

    public List<role> rolelist() {
        return user.rolelist();
    }

    public int deletes(int id) {
        return user.deletes(id);
    }

    public int insertrole(role role) {
        return user.insertrole(role);
    }

    public int roleupdates(role bill) {
        return user.roleupdates(bill);
    }

    public role roles(int id) {
        return user.roles(id);
    }

    public int uppwd(String pwd, String pwds,int id) {
        return user.uppwd(pwd,pwds,id);
    }

    public int roledeletes(int id) {
        return roledeletes(id);
    }
}
