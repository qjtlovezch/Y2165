package cn.bdqn.aop.service;

import cn.bdqn.aop.IDAO;
import cn.bdqn.aop.User;


public class UserBiz implements IUserBiz {
    private IDAO dao;

    public IDAO getDao() {
        return dao;
    }

    public void setDao(IDAO dao) {
        this.dao = dao;
    }

    public void seav(User user) {
        dao.seave(user);
    }
}
