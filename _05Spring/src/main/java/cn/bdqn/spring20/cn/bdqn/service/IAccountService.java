package cn.bdqn.spring20.cn.bdqn.service;

import cn.bdqn.spring20.cn.bdqn.entity.Account;
import cn.bdqn.spring20.cn.bdqn.entity.Stock;
import cn.bdqn.spring20.cn.bdqn.entity.StockException;

/**
 * Created by QiuShao on 2017/8/4.
 */
public interface IAccountService {

    public boolean addAccount(Account account);

    public boolean addStock(Stock account);



    public void buyStock(int sid,int count,int aid,double money) throws StockException;

}
