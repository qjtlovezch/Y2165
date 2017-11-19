package cn.tenement.Service;

import cn.tenement.Dao.IBillDao;
import cn.tenement.Entity.bill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunbin on 2017/8/23.
 */
@Service("billService")
public class BillServiceImpl implements IbillService {
    @Resource
    IBillDao bill;
    public List<bill> list( int pageIndex,int pageSize,@Param("proName") String proName) {
        return bill.list(pageIndex,pageSize,proName);
    }

    public int inserts(bill bills) {

        return bill.inserts(bills);
    }

    public bill selects(String billCode) {
        return bill.selects(billCode);
    }

    public int updates(bill bills) {
        return bill.updates(bills);
    }

    public int count( @Param("proName") String proName) {
        return bill.count(proName);
    }

    public List<bill> list2(int pageIndex,int pageSize) {
        return bill.list2(pageIndex,pageSize);
    }

    public int deletes(int id) {
        return bill.deletes(id);
    }
}
