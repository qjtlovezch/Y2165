package cn.tenement.Service;

import cn.tenement.Entity.bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sunbin on 2017/8/23.
 */
public interface IbillService {
    public List<bill> list(int pageIndex, int pageSize, @Param("proName") String proName);
  public  int inserts(bill bill);
  public bill selects(String billCode);
  public int updates(bill bill);
    public int count(@Param("proName") String proName);
    public List<bill> list2(int pageIndex, int pageSize);
    public int deletes(int id);
}
