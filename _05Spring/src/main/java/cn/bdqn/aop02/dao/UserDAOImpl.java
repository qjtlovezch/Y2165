package cn.bdqn.aop02.dao;


import cn.bdqn.aop02.entity.User;

/**
 * Created by Happy on 2017-07-24.
 */
public class UserDAOImpl implements IUserDAO {
    public void save(User user) {
        System.out.println("save success!");
    }
}
