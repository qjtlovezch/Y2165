package cn.tenement.Dao;

import cn.tenement.Entity.bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sunbin on 2017/8/23.
 */
public interface IBillDao {

    public List<bill> list(int pageIndex, int pageSize, @Param("proName") String proName);

  public int count(@Param("proName") String proName);
  public List<bill> list2(int pageIndex, int pageSize);
    public  int inserts(bill bill);
    public  bill selects(String billCode);
  public int updates(bill bill);
    public int deletes(int id);

}