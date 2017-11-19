package cn.smbms.dao;

import cn.smbms.entity.Bill;
import cn.smbms.entity.Provider;

import java.util.List;
import java.util.Map;

/**
 * Created by java on 2017-9-5.
 */
public interface BillDao {

   public List<Bill> getBill();//列表及分页
   public Bill biuest(int id);  //根据id查看信息
   public int Addbill(Bill bill); //添加
    public Bill  getb(int id); //根据id查询，修改传值
    public int Bupdate(Bill id); //修改
    public int Bdelete(int id); //删除

    public List<Bill>getBills(Map<String, Object> map);

}
