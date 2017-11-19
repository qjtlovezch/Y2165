package cn.bdqn.dao;

import cn.bdqn.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by QiuShao on 2017/7/13.
 */
public interface UserMapper {

   /* if-set 修改*/
    public int modify(User user);

    /*if-trim 修改*/
    public int mod(User user);

    /*if-trim 查询*/
    public List<User> getUserList(User user);














}
