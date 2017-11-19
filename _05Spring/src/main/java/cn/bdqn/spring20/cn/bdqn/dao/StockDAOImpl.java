package cn.bdqn.spring20.cn.bdqn.dao;

import cn.bdqn.spring20.cn.bdqn.entity.Stock;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by QiuShao on 2017/8/4.
 */
public class StockDAOImpl extends JdbcDaoSupport implements IStockDAO {
    public boolean addStock(Stock stock) {
        return false;
    }

    public boolean updateStock(int sid, int count, boolean isBuy) {
        boolean flag=false;
        String sql=null;
        if (isBuy){  //购买股票
            sql="update stock set count=count+? where sid=?";
        }else{
            sql="update stock set count=count-? where sid=?";
        }
        int str = this.getJdbcTemplate().update(sql, count, sid);
        if (str>0){
            flag=true;
        }
        return flag;
    }
}
