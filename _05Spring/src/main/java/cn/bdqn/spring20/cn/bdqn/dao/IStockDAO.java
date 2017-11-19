package cn.bdqn.spring20.cn.bdqn.dao;

import cn.bdqn.spring20.cn.bdqn.entity.Stock;

/**
 * Created by QiuShao on 2017/8/4.
 */
public interface IStockDAO {
    public boolean addStock(Stock stock);
    public boolean updateStock(int sid,int count,boolean isBuy);

}
