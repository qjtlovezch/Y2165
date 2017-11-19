package cn.bdqn.aop02.service;


import cn.bdqn.aop02.dao.IUserDAO;
import cn.bdqn.aop02.entity.User;

/**
 * Created by Happy on 2017-07-24.
 */
public class UserServiceImpl implements IUserService {
    private IUserDAO dao;
    public void save2(User user) {
        dao.save(user);
    }

    public IUserDAO getDao() {
        return dao;
    }

    public void setDao(IUserDAO dao) {
        this.dao = dao;
    }
}
