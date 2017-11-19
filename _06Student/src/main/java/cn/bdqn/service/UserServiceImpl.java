package cn.bdqn.service;

import cn.bdqn.dao.IUserDAO;
import cn.bdqn.entity.User;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class UserServiceImpl implements IUserService{

    private IUserDAO dao;

    public IUserDAO getDao() {
        return dao;
    }

    public void setDao(IUserDAO dao) {
        this.dao = dao;
    }


    @Override
    public int isLogin(User info) {
        return dao.isLogin(info);
    }
}
