package cn.bdqn.spring20.cn.bdqn.dao;

import cn.bdqn.spring20.cn.bdqn.entity.Account;

/**
 * Created by QiuShao on 2017/8/4.
 */
public interface IAccountDAO {
    //开户的方法
    public boolean addAccount(Account account);
    //修改账户余额  金额减少true
    public boolean updateAccount(int aid,double money,boolean isBuy);
}
