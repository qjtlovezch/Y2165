package cn.bdqn.spring20.cn.bdqn.service;

import cn.bdqn.spring20.cn.bdqn.dao.IAccountDAO;
import cn.bdqn.spring20.cn.bdqn.dao.IStockDAO;
import cn.bdqn.spring20.cn.bdqn.entity.Account;
import cn.bdqn.spring20.cn.bdqn.entity.Stock;
import cn.bdqn.spring20.cn.bdqn.entity.StockException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by QiuShao on 2017/8/4.
 */
public class AccountServiceImpl implements IAccountService {
    //植入AccountDao對象
    private IAccountDAO accountDAO;
    //植入StockDAO對象
    private IStockDAO stockDAO;
    public boolean addAccount(Account account) {
        return false;
    }

    public boolean addStock(Stock account) {
        return false;
    }

   /* @Transactional(rollbackFor = StockException.class)*/
    public void buyStock(int sid, int count, int aid, double money) throws StockException {
        boolean isBuy=true;
        accountDAO.updateAccount(aid,money,isBuy);

        if(1==1) {
            throw new StockException();
        }
        stockDAO.updateStock(sid,count,isBuy);
    }

    public IAccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public IStockDAO getStockDAO() {
        return stockDAO;
    }

    public void setStockDAO(IStockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }
}
