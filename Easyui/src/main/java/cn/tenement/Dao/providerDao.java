package cn.tenement.Dao;

import cn.tenement.Entity.Provider;
import cn.tenement.Entity.bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sunbin on 2017/9/6.
 */
public interface providerDao {

    public List<Provider> list(int pageIndex, int pageSize);
   public int inserts(Provider provider);
    public int count(@Param("proName") String proName);
    public Provider provider(int id);
    public int update(Provider provider);
    public int delect(int id);
    public List<Provider> lists(int pageIndex, int pageSize, @Param("proName") String proName);
}
